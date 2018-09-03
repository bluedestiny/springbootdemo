package com.example.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.User;
/**
 * 
 * @author admin
 *  继承ElasticsearchRepository	
 *  继承JpaRepository<User, Long>
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User,Long> {
    
	User findByName(String name);
    
}