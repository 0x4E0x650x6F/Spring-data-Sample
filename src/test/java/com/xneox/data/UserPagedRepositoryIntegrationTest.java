package com.xneox.data;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.PageRequest;
import com.xneox.data.domains.User;
import com.xneox.repositories.Users;

@ContextConfiguration(locations = "classpath:com/xneox/data/UserPagedRepositoryIntegrationTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional

public class UserPagedRepositoryIntegrationTest {
	
	@Autowired
	Users repository;
	
	@Autowired 
	List<User> userList; 
	
	User user;

	@Before
	public void setUp() {
		assertNotNull(repository);
		assertNotNull(userList);
		repository.save(userList);
	}
	 
	@Test
	public void testUserListSize() throws Exception {
		
		List<User> users = repository.findAll();

		assertNotNull(users);
		Assert.assertEquals(users.size(), 8);
	}
	
	@Test
	public void testUserListPaged() throws Exception {
		Pageable page = new PageRequest(1, 2);
		
		Page<User> users = repository.findAll(page);

		assertNotNull(users);
		Assert.assertEquals(users.getTotalPages(), 4);
	}
	
}
