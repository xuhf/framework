package com.isharec.framework.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.isharec.framework.base.persistence.BaseDao;
import com.isharec.framework.base.persistence.Parameter;
import com.isharec.framework.entity.User;

@Repository
public class UserDao extends BaseDao<User> {

	public List<User> findAllList() {
		return findAll();
	}

	public User findByLoginName(String loginName) {
		return getByHql("from User where loginName = :p1", new Parameter(loginName));
	}

	public int updatePasswordById(String newPassword, Long id) {
		return update("update User set password=:p1 where id = :p2",
				new Parameter(newPassword, id));
	}

	public int updateLoginInfo(String loginIp, Date loginDate, Long id) {
		return update(
				"update User set loginIp=:p1, loginDate=:p2 where id = :p3",
				new Parameter(loginIp, loginDate, id));
	}
}
