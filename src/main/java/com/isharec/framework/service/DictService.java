package com.isharec.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseService;
import com.isharec.framework.dao.DictHeaderDao;
import com.isharec.framework.dao.DictItemDao;
import com.isharec.framework.entity.DictHeader;
import com.isharec.framework.entity.DictItem;

@Service
@Transactional
public class DictService extends BaseService {

	@Autowired
	private DictHeaderDao dictHeaderDao;

	@Autowired
	private DictItemDao dictItemDao;

	/**** 数据字典　Header *****/
	public Page<DictHeader> page(Page<DictHeader> page) {
		return dictHeaderDao.find(page);
	}

	public DictHeader getDictHeader(Long id) {
		return dictHeaderDao.get(id);
	}

	public DictHeader findDictHeaderByValue(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return null;
		}
		return dictHeaderDao.findByValue(value);
	}

	public void saveDictHeader(DictHeader dictHeader) {
		dictHeaderDao.save(dictHeader);
	}

	public void deleteDictHeader(DictHeader dictHeader) {
		dictHeaderDao.delete(dictHeader);
	}

	/**** 数据字典　Item *****/
	public DictItem getDictItem(Long id) {
		return dictItemDao.get(id);
	}

	public DictItem getDictItem(DictHeader dictHeader, String value) {
		return dictItemDao.findByHeaderAndValue(dictHeader, value);
	}

	public void saveDictItem(DictItem dictItem) {
		dictItemDao.save(dictItem);
	}

	public void deleteDictItem(DictItem dictItem) {
		dictItemDao.delete(dictItem);
	}
}
