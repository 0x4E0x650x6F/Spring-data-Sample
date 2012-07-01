package com.xneox.data.domains.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.xneox.data.domains.Log;

/**
 * 
 * @author neo
 *
 */
//TODO change this implementation to something decent!
public class LogSpecifications {
	public static Specification<Log> allWithError() {
		Specification<Log> logSepesification = new Specification<Log>() {

			@Override
			public Predicate toPredicate(Root<Log> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				Integer errorcode = new Integer(0);
				Root<Log> logs = query.from(Log.class);
				Path<Integer> error = logs.<Integer> get("error");
				
				return cb.greaterThan(error, errorcode);
			}
		   
	   };
	   return logSepesification;
	}
}
