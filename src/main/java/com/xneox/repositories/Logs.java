package com.xneox.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xneox.data.domains.Log;

public interface Logs extends JpaRepository<Log, Long>, JpaSpecificationExecutor<Log> {
	
	Page<Log> findByService(String service, Pageable pageable);
								   
	Page<Log> findByProcess(String process, Pageable pageable);

	List<Log> findByLocal(String local);
	
}
