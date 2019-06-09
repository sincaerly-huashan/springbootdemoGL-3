package com.example.demo.helloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @ClassName:  HelloController   
 * @Description:测试类看程序运行是不是正常 
 * @author: 千年老妖  1919161453@qq.com  
 * @date:   2019年5月30日 下午1:44:26   
 *     
 * @Copyright: 2019  
 * 注意：本内容仅限于郭氏企业内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!!";
	}

}
