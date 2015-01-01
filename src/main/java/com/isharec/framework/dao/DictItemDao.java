package com.isharec.framework.dao;

import org.springframework.stereotype.Repository;

import com.isharec.framework.base.persistence.BaseDao;
import com.isharec.framework.base.persistence.Parameter;
import com.isharec.framework.entity.DictHeader;
import com.isharec.framework.entity.DictItem;

@Repository
public class DictItemDao extends BaseDao<DictItem> {

	public DictItem findByHeaderAndValue(DictHeader dictHeader, String value) {
		String hql = "from DictItem di where di.dictHeader = :p1 and di.value = :p2";
		return getByHql(hql, new Parameter(dictHeader, value));
	}
}
