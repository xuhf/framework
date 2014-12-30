package com.isharec.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isharec.framework.base.web.BaseService;
import com.isharec.framework.dao.MenuDao;
import com.isharec.framework.entity.Menu;
import com.isharec.framework.security.SystemAuthorizingRealm;
import com.isharec.framework.utils.UserUtils;

@Service
@Transactional
public class MenuService extends BaseService {

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private SystemAuthorizingRealm systemRealm;

	public Menu getMenu(Long id) {
		if (id == 0L) {
			return new Menu(0L);
		}
		return menuDao.get(id);
	}

	public List<Menu> findAllMenu() {
		return UserUtils.getMenuList();
	}

	public void saveMenu(Menu menu) {
		menu.setParent(this.getMenu(menu.getParent() == null ? 0L : menu
				.getParent().getId()));
		String oldParentIds = menu.getParentIds(); // 获取修改前的parentIds，用于更新子节点的parentIds
		menu.setParentIds(menu.getParent().getParentIds()
				+ menu.getParent().getId() + ",");
		menuDao.clear();
		menuDao.save(menu);
		// 更新子节点 parentIds
		List<Menu> list = menuDao.findByParentIdsLike("%," + menu.getId()
				+ ",%");
		for (Menu e : list) {
			e.setParentIds(e.getParentIds().replace(oldParentIds,
					menu.getParentIds()));
		}
		menuDao.save(list);
		systemRealm.clearAllCachedAuthorizationInfo();
		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
	}

	public void deleteMenu(Long id) {
		menuDao.deleteById(id, "%," + id + ",%");
		systemRealm.clearAllCachedAuthorizationInfo();
		UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);
	}
}
