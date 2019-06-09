package com.example.demo.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在连接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {
    
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//    	获取页面传递参数L的值
        String l = request.getParameter("l");
//      获取自定义国际化Locale区域信息对象的值；如果页面传过来URL时没有带参数国际化Locale区域信息对象的值，我们就使用Springboot中的默认值;
        Locale locale = Locale.getDefault();
//      页面传递URL例子：http://localhost:8080/index.html?l=en_US对参数?l=en_US进行如下解析
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
