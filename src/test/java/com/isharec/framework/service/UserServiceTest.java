package com.isharec.framework.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.isharec.framework.entity.Role;
import com.isharec.framework.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring-hibernate*.xml",
		"classpath*:/spring-mvc*.xml" })
/*
 * @TransactionConfiguration(transactionManager = "transactionManager")
 * 
 * @Transactional
 */
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testSave() {
//		User user = new User();
//		user.setLoginName("system");
//		user.setName("系统管理员");
//		String password = UserService.entryptPassword("123456");
//		System.out.println(password);
//		user.setPassword(password);
//		user.setEmail("xuhf_1988@163.com");
//		user.setEnabled(true);
//		List<Role> list = Lists.newArrayList();
//		user.setRoleList(list);
//		// userService.saveUser(user);
		System.out.println("3826d1c4ab0a01fb32018ca4015b2b092eb3ff7d793b18b5091744df".length());
	}

}
