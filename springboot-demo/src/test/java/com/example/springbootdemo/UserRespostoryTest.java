package com.example.springbootdemo;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.domain.User;
import com.example.jpa.dao.UserJpaRepository;
@RunWith(SpringRunner.class) 
@SpringBootTest
@WebAppConfiguration
public class UserRespostoryTest {
	
	@Autowired
	private UserJpaRepository userJpaRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
		String formattedDate = dateFormat.format(date);
		
		userJpaRepository.save(new User("aa1", 22));
		userJpaRepository.save(new User("bb2", 23));
		userJpaRepository.save(new User("cc3", 23));
		System.out.println(userJpaRepository.findAll().size());
		/*Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByName("bb").getName());*/
		//userRepository.delete(userRepository.findByName("bb"));
	}

}
