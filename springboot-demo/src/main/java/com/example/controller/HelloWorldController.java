package com.example.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.es.dao.UserRepository;
import com.example.jpa.dao.UserJpaRepository;
import com.example.service.UserServiceImpl;


@RestController
public class HelloWorldController {
	@Autowired
	UserJpaRepository userRepository;
	@Autowired
	UserRepository searchRepository;
	@Autowired
	private UserServiceImpl userService;
	 
	@RequestMapping("user/delete/{id}")
	public void deleteByName(@PathVariable Long id) {
	    userRepository.deleteById(id);
	}
	@RequestMapping("/users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	@RequestMapping("/list")
	public Iterable<User> list() {
		String[] name = {"张","王","李","赵","孙","朱","任"};
		Random ran = new Random();
		User user;
		for (int i=0; i<100; i++) {
			user = new User(name[ran.nextInt(name.length)]
					+ name[ran.nextInt(name.length)]
					+ name[ran.nextInt(name.length)], i);
			user.setId(System.currentTimeMillis());
			userService.save(user);
		}
	    return userService.findAll();
	}

	@RequestMapping("/findUserByName")
	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    @RequestMapping("/findByQuery")
    public List<User> findListByQuery(String query) {
    	List list = new ArrayList();
    	//String queryString="springboot";//搜索关键字
		QueryStringQueryBuilder builder=new QueryStringQueryBuilder(query);
		Iterable<User> searchResult = searchRepository.search(builder);
		Iterator<User> iterator = searchResult.iterator();
		while(iterator.hasNext()){
			//System.out.println(iterator.next());
			list.add(iterator.next());
		}
		return list;
    }
}
