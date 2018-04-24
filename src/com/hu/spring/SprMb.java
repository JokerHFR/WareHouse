package com.hu.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprMb {
	public static ApplicationContext actx;
	static{
		String[]args = new String[] {
				"classpath:/ApplicationContext.xml",
				"classpath:/SqlMapConfig.xml",
				};
				actx = new ClassPathXmlApplicationContext(args);
	}

}
