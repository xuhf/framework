package com.isharec.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseService;
import com.isharec.framework.dao.SystemParameterDao;
import com.isharec.framework.entity.SystemParameter;

@Service
@Transactional
public class SystemParameterService extends BaseService {

	@Autowired
	private SystemParameterDao systemParameterDao;

	public Page<SystemParameter> page(Page<SystemParameter> page) {
		return systemParameterDao.find(page);
	}

	public void saveSystemParameter(SystemParameter systemParameter) {
		systemParameterDao.save(systemParameter);
	}

	public SystemParameter getSystemParameter(Long id) {
		return systemParameterDao.get(id);
	}

	public void deleteSystemParameter(Long id) {
		systemParameterDao.delete(id);
	}

	public void deleteSystemParameter(SystemParameter systemParameter) {
		systemParameterDao.delete(systemParameter);
	}
}
