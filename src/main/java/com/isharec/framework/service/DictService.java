package com.isharec.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseService;
import com.isharec.framework.dao.DictHeaderDao;
import com.isharec.framework.dao.DictItemDao;
import com.isharec.framework.entity.DictHeader;

@Service
@Transactional
public class DictService extends BaseService {

	@Autowired
	private DictHeaderDao dictHeaderDao;

	@Autowired
	private DictItemDao dictItemDao;

	public void save(DictHeader dictHeader) {
		dictHeaderDao.save(dictHeader);
	}
	
	public Page<DictHeader> page(Page<DictHeader> page) {
		return null;
	}
}
