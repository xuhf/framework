package com.isharec.framework.service;

import java.util.List;

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

	public Dict get(Long id) {
		return dictDao.get(id);
	}

	public List<Dict> findAll(Long id) {
		return dictDao.findAll();
	}

	public void update(Dict dict) {
		dictDao.update(dict);
	}

	public void delete(Long id) {
		Dict d = get(id);
		delete(d);
	}

	public void delete(Dict dict) {
		dictDao.delete(dict);
	}
}
