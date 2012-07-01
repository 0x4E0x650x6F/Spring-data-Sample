package com.xneox.data;

import static com.xneox.data.domains.Specification.LogSpecifications.allWithError;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xneox.data.domains.Log;
import com.xneox.repositories.Logs;

@ContextConfiguration(locations = "classpath:com/xneox/data/LogsPagedRepositoryIntegrationTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class LogsPagedRepositoryIntegrationTest {
	
	
	@Autowired
	Logs repository;
	
	@Autowired 
	List<Log> logList; 
	
	Log log;
	
	@Before
	public void setUp() {
		assertNotNull(repository);
		assertNotNull(logList);
		repository.save(logList);
	}
	
	@Test
	public void testLogListSize() throws Exception {
		
		List<Log> logs = repository.findAll();
	
		assertNotNull(logs);
		Assert.assertEquals(logs.size(), 3);
	}
	
	@Test
	public void testLogByProcessNameListPaged() throws Exception {
		Pageable page = new PageRequest(0, 3);
		
		Page<Log> logs = repository.findByProcess("createuser", page);
		Log log = logs.getContent().get(0);
		Assert.assertEquals("createuser", log.getProcess());
		
	}
	@Test
	public void testLogSepesification() throws Exception {
		
		List<Log> logs = repository.findAll(allWithError());
		
		Assert.assertEquals(9, logs.size());
		
	}
	
}
