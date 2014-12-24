package com.isharec.framework.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.isharec.framework.entity.Dict;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring-hibernate*.xml",
		"classpath*:/spring-mvc*.xml" })
/*@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional*/
public class DictServiceTest {

	@Autowired
	private DictService dictService;

	@Test
	public void testSave() {
		Dict dict = new Dict();
		dict.setName("name1");
		dict.setValue("value1");
		dictService.save(dict);
	}
}
