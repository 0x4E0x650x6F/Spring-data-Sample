package com.xneox.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xneox.data.domains.User;

public interface Users extends JpaRepository<User, Long> {
	List<User> findByLastname(String lastname);

	List<User> findByFirstname(String firstname, Pageable pageable);

}
