package com.example.demo.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Email;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
/**
 * 
 * @ClassName:  PersonTest 
 * @Validated 检验注解  这个注解必须与元素上面注解一起来使用如lastName+@Email
 *    报错信息：default message [不是一个合法的电子邮件地址]
 * @Component 使用 ConfigurationProperties注解时必须使用容器这个注解
 * @Description:
 * @author: 千年老妖  1919161453@qq.com  
 * @date:   2019年5月30日 下午8:03:01   
 *     
 * @Copyright: 2019  
 * 注意：本内容仅限于郭氏企业内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
@ConfigurationProperties(prefix = "personTest")
@Validated 
public class PersonTest {
	
	 /**
     * <bean class="Person">
     *      <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * <bean/>
     */
	
//	 	@Value("${person.last-name}")
//	    @Email
	    private String lastName;
//	 	@Value("#{11*2}")
	    private Integer age;
//	 	@Value("true")
	    private Boolean boss;
//	    @DateTimeFormat
	    private Date birth;
	    private Map<String,Object> maps;
	    private List<Object> lists;
	    private Dog dog;
		@Override
		public String toString() {
			return "PersonTest [lastName=" + lastName + ", age=" + age + ", boss=" + boss + ", birth=" + birth
					+ ", maps=" + maps + ", lists=" + lists + ", dog=" + dog + "]";
		}
		
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public Boolean getBoss() {
			return boss;
		}
		public void setBoss(Boolean boss) {
			this.boss = boss;
		}
		public Date getBirth() {
			return birth;
		}
		public void setBirth(Date birth) {
			this.birth = birth;
		}
		public Map<String, Object> getMaps() {
			return maps;
		}
		public void setMaps(Map<String, Object> maps) {
			this.maps = maps;
		}
		public List<Object> getLists() {
			return lists;
		}
		public void setLists(List<Object> lists) {
			this.lists = lists;
		}
		public Dog getDog() {
			return dog;
		}
		public void setDog(Dog dog) {
			this.dog = dog;
		}

	    

}
