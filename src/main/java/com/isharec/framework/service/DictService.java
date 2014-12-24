package com.isharec.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isharec.framework.base.web.BaseService;
import com.isharec.framework.dao.DictDao;
import com.isharec.framework.entity.Dict;

@Service
@Transactional
public class DictService extends BaseService {

	@Autowired
	private DictDao dictDao;

	public void save(Dict dict) {
		dictDao.save(dict);
	}
}
