package com.xneox.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xneox.data.domains.User;
import com.xneox.repositories.Users;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserRepositoryIntegrationTest {

	@Autowired
	Users repository;

	User user;

	@Before
	public void setUp() {

		user = new User();
		user.setFirstname("firstname");
		user.setLastname("lastname");
	}

	@Test
	public void testFindByLastName() throws Exception {

		user = repository.save(user);

		List<User> users = repository.findByLastname("lastname");

		assertNotNull(users);
		assertTrue(users.contains(user));
	}

}