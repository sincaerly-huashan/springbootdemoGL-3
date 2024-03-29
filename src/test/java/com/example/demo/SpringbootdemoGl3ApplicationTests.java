package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Person;
import com.example.demo.bean.PersonTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoGl3ApplicationTests {
	
	@Autowired
	Person person;
	
	@Autowired
	PersonTest persontest;
	
	@Autowired
	ApplicationContext ioc;
	
	//日志记录器
	 Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 
	 * @Title: testHelloService   
	 * @Description: SpringBoot推荐给容器中添加组件的方法
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	@Test
	public void testHelloService(){
		boolean b = ioc.containsBean("helloService02");
//		System.out.println(b);
	}

	@Test
	public void contextLoads() {
		
//		System.out.println(person);
//		System.out.println(persontest);
	}
	
	/**
	 * 
	 * @Title: contextLoggers   
	 * @Description: 记录日志的级别   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	@Test
	public void contextLoggers() {
		
		//日志的级别；
		//由低到高   trace < debug < info < warn < error
		//可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
		logger.trace("这是trace日志...");
		logger.debug("这是debug日志...");
		//SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
		logger.info("这是info日志...");
		logger.warn("这是warn日志...");
		logger.error("这是error日志...");
	}

}
