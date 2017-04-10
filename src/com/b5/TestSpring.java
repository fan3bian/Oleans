package com.b5;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestSpring {
	public static void main(String[] args) {
		// 根据xml文件获得注入
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		// getBean 对应 xml <bean>的id
		HelloWorld he = (HelloWorld) context.getBean("helloWorld");
		// <property> name属性 对应 Class属性 ，value对应Class属性值
		System.out.println(he.getMessage());
	}

	@Test
	public void test() {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		System.out.println(obj.getMessage());
	}

	@Test
	public void testfscpAppcontext() {
		String filepath = "D:\\Beans.xml";
		ApplicationContext context = new FileSystemXmlApplicationContext(filepath);
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj.getMessage());
	}

	@Test // scope缺省情况下，IOC容器采用singleton模式来创建bean实例
	public void testSingletonScope() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		// getBean 对应 xml <bean>的id
		HelloWorld obj1 = (HelloWorld) context.getBean("shatuzi");
		// <property> name属性 对应 Class属性 ，value对应Class属性值
		obj1.setMessage("sha tu zi");
		System.out.println(obj1.getMessage());
		HelloWorld obj2 = (HelloWorld) context.getBean("shatuzi");
		// <property> name属性 对应 Class属性 ，value对应Class属性值
		System.out.println(obj2.getMessage());
		System.out.println(obj1 == obj2);
	}

	@Test
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		// getBean 对应 xml <bean>的id
		HelloWorld obj1 = (HelloWorld) context.getBean("lovelyrabbit");
		obj1.setMessage("sha tuzi");
		System.out.println(obj1.getMessage());
		HelloWorld obj2 = (HelloWorld) context.getBean("lovelyrabbit");
		System.out.println(obj2.getMessage());
		System.out.println(obj1 == obj2);
	}
	@Test//混乱，加载的明明是helloworld, 结果和加载 initdestory一样
	//
	public void initdestory() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj.getMessage());
		context.registerShutdownHook();
	}
}
