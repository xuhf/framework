package com.isharec.framework.dao;

import org.springframework.stereotype.Repository;

import com.isharec.framework.base.persistence.BaseDao;
import com.isharec.framework.base.persistence.Parameter;
import com.isharec.framework.entity.DictHeader;

@Repository
public class DictHeaderDao extends BaseDao<DictHeader> {

	public DictHeader findByValue(String value) {
		return getByHql("from DictHeader where value = :p1", new Parameter(
				value));
	}
}
