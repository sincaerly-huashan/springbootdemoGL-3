package com.example.demo.helloController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;

@Controller
public class EmployeeController {
	
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
     @GetMapping("/emps")
    public String  list(Model model){
    	 
    	//查询所有员工的集合
        Collection<Employee> employees = employeeDao.getAll();

        //将查询到的员工集合放在请求域中，好让员工页面（emp/lists.html）使用员工集合的数据
        model.addAttribute("emps",employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "emp/lists";
    }
     
     //来到员工添加页面
     /**
      * 
      * @Title: toAddPage   
      * @Description: 点击员工添加按钮时调用此方法跳转到员工添加页面内，跳转add.html员工添加页面时需要使用部分下拉的列表，所以查询所有部门的数据
      * @param: @param model 因为部门数据要在页面显示所以使用
      * @param: @return      
      * @return: String      
      * @throws
      */
     @GetMapping("/emp")
     public String toAddPage(Model model){
         //来到添加页面,查出所有的部门，在页面显示
         Collection<Department> departments = departmentDao.getDepartments();
         model.addAttribute("depts",departments);
         return "emp/add";
     }
     
     //员工添加
     //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
     @PostMapping("/emp")
     public String addEmp(Employee employee){
         //来到员工列表页面

         System.out.println("保存的员工信息："+employee);
         //保存员工
         employeeDao.save(employee);
         // redirect: 表示重定向到一个地址  /代表当前项目路径
         // forward: 表示转发到一个地址
         return "redirect:/emps";
     }
     
     
 
     /**
      * 
      * @Title: toEditPage   
      * @Description: 来到修改页面，查出当前员工，在页面回显  
      * @param: @param id  此处是获取路径变量的方法@PathVariable("id")
      * @param: @param model  model 因为部门数据要在页面显示所以使用，页面参数
      * @param: @return      
      * @return: String      
      * @throws
      */
     @GetMapping("/emp/{id}")
     public String toEditPage(@PathVariable("id") Integer id,Model model){
         Employee employee = employeeDao.get(id);
         model.addAttribute("emp",employee);

         //页面要显示所有的部门列表
         Collection<Department> departments = departmentDao.getDepartments();
         model.addAttribute("depts",departments);
         //回到修改页面(add是一个修改添加二合一的页面);
         return "emp/add";
     }
     
     //员工修改；需要提交员工id；
     @PutMapping("/emp")
     public String updateEmployee(Employee employee){
         System.out.println("修改的员工数据："+employee);
         employeeDao.save(employee);
         return "redirect:/emps";
     }
     
     //员工删除
     @DeleteMapping("/emp/{id}")
     public String deleteEmployee(@PathVariable("id") Integer id){
         employeeDao.delete(id);
         return "redirect:/emps";
     }


}
