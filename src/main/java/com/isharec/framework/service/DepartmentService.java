package com.isharec.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isharec.framework.base.web.BaseService;
import com.isharec.framework.dao.DepartmentDao;
import com.isharec.framework.entity.Department;

@Service
@Transactional
public class DepartmentService extends BaseService {

	@Autowired
	private DepartmentDao departmentDao;

	public void saveDepartment(Department department) {
		departmentDao.save(department);
	}

	public List<Department> findAllDepartment() {
		return departmentDao.findAll();
	}

	public Department getDepartment(Long id) {
		return departmentDao.get(id);
	}

	public void deleteDepartment(Long id) {
		departmentDao.delete(id);
	}
}
