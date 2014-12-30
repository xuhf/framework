package com.isharec.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseService;
import com.isharec.framework.dao.RoleDao;
import com.isharec.framework.entity.Role;
import com.isharec.framework.entity.User;
import com.isharec.framework.security.SystemAuthorizingRealm;
import com.isharec.framework.utils.UserUtils;

@Service
@Transactional
public class RoleService extends BaseService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private SystemAuthorizingRealm systemRealm;

	@Autowired
	private UserService userService;

	public Role getRole(Long id) {
		return roleDao.get(id);
	}

	public Role findRoleByName(String name) {
		return roleDao.findByName(name);
	}

	public List<Role> findAllRole() {
		return UserUtils.getRoleList();
	}

	public Page<Role> page(Page<Role> page) {
		return roleDao.find(page);
	}

	@Transactional(readOnly = false)
	public void saveRole(Role role) {
		roleDao.clear();
		roleDao.save(role);
		systemRealm.clearAllCachedAuthorizationInfo();
		UserUtils.removeCache(UserUtils.CACHE_ROLE_LIST);
	}

	@Transactional(readOnly = false)
	public void deleteRole(Long id) {
		roleDao.delete(getRole(id));
		systemRealm.clearAllCachedAuthorizationInfo();
		UserUtils.removeCache(UserUtils.CACHE_ROLE_LIST);
	}

	@Transactional(readOnly = false)
	public Boolean outUserInRole(Role role, Long userId) {
		User user = userService.getUser(userId);
		List<Long> roleIds = user.getRoleIdList();
		List<Role> roles = user.getRoleList();
		//
		if (roleIds.contains(role.getId())) {
			roles.remove(role);
			userService.saveUser(user);
			return true;
		}
		return false;
	}

	@Transactional(readOnly = false)
	public User assignUserToRole(Role role, String userId) {
		User user = userService.getUser(Long.parseLong(userId));
		List<Long> roleIds = user.getRoleIdList();
		if (roleIds.contains(role.getId())) {
			return null;
		}
		user.getRoleList().add(role);
		userService.saveUser(user);
		return user;
	}

}
