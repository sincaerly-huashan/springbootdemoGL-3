package com.example.demo.helloController;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//这个类的所有方法返回的数据直接写给浏览器，（如果是对象转为json数据）
/**
 * 
 * @ClassName:  HelloController1   
 * @Description: @ResponseBody与 @RestController这个注解在跳转页面时是不能使用，它的意思是将数据返回到页面上显示 
 * @author: 千年老妖  1919161453@qq.com  
 * @date:   2019年6月1日 下午2:17:01   
 *     
 * @Copyright: 2019  
 * 注意：本内容仅限于郭氏企业内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class HelloController1 {
	
	
	/*
	 * @RequestMapping({ "/", "/index.html" }) public String index() { return
	 * "index"; }
	 */
	
	@ResponseBody
	@RequestMapping("/hello1")
    public String hello(){
        return "hello world quick!";
    }
	 
	
 	@RequestMapping("/success")
    public String success(Map<String,Object> map) {
 		map.put("hello", "你好！！！");
 		map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
    	return "success";
    }
 	
 	@GetMapping("abdij")
    public String succes(Map<String,Object> map) {
 		map.put("hello", "你好！！！");
 		map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
    	return "add/succes";
    }
 	
 	
 	

}
