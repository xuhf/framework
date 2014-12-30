package com.isharec.framework.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.isharec.framework.base.persistence.BaseDao;
import com.isharec.framework.base.persistence.Parameter;
import com.isharec.framework.entity.Menu;

@Repository
public class MenuDao extends BaseDao<Menu> {

	public List<Menu> findByParentIdsLike(String parentIds) {
		String hql = "from Menu m where m.parentIds like :p1";
		return find(hql, new Parameter(parentIds));
	}

	public List<Menu> findAllList() {
		return find("from Menu order by sort");
	}

	public List<Menu> findByUserId(Long userId) {
		String hql = "select distinct m from Menu m, Role r, User u where m in elements (r.menuList) and r in elements (u.roleList) and u.id=:p1 order by m.sort";
		return find(hql, new Parameter(userId));
	}

	public void deleteById(Long id, String parentIds) {
		Menu menu = get(id);
		delete(menu);
		List<Menu> childrenList = findByParentIdsLike(parentIds);
		for (Menu childrenMenu : childrenList) {
			delete(childrenMenu);
		}
	}
}
