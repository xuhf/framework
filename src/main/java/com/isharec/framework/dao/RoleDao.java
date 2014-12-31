package com.isharec.framework.dao;

import org.springframework.stereotype.Repository;

import com.isharec.framework.base.persistence.BaseDao;
import com.isharec.framework.base.persistence.Parameter;
import com.isharec.framework.entity.Role;

@Repository
public class RoleDao extends BaseDao<Role> {

	public Role findByName(String name) {
		return getByHql("from Role where name = :p1", new Parameter(name));
	}
}
