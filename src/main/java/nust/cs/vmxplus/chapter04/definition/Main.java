package nust.cs.vmxplus.chapter04.definition;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
	public static void main(String[] args) {
		
		//sayHelloWorldByClass();
		sayHelloWorldById();
		sayHelloWorldByName();
		sayHelloWorldByIdAndName();
		sayHelloWorldByMultiName();
		sayHelloWorldByAlias();
	}
	
	public static void sayHelloWorldByClass(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-definition.xml");
		
		IHelloWorld ihelloWorld = beanFactory.getBean(HelloWorldImpl.class);
		ihelloWorld.sayHello();
	}
	
	public static void sayHelloWorldById(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-definition.xml");
		IHelloWorld iHelloWorld = (IHelloWorld)beanFactory.getBean("helloWorld", IHelloWorld.class);
		iHelloWorld.sayHello();
	}
	
	public static void sayHelloWorldByName(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-definition.xml");
		IHelloWorld iHelloWorld = (IHelloWorld)beanFactory.getBean("helloWorldByName", IHelloWorld.class);
		iHelloWorld.sayHello();
	}
	
	public static void sayHelloWorldByIdAndName(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-definition.xml");
		IHelloWorld iHelloWorld01 = (IHelloWorld)beanFactory.getBean("helloWorldById", IHelloWorld.class);
		iHelloWorld01.sayHello();
		IHelloWorld iHelloWorld02 = (IHelloWorld)beanFactory.getBean("helloWorldByName01", IHelloWorld.class);
		iHelloWorld02.sayHello();
	}
	
	public static void sayHelloWorldByMultiName(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-definition.xml");
		IHelloWorld bean1 = (IHelloWorld)beanFactory.getBean("bean1", IHelloWorld.class);
		bean1.sayHello();
		
		IHelloWorld bean12 = (IHelloWorld)beanFactory.getBean("alias11", IHelloWorld.class);
		bean12.sayHello();
		
		IHelloWorld bean2 = (IHelloWorld)beanFactory.getBean("bean2", IHelloWorld.class);
		bean2.sayHello();
	}
	
	public static void sayHelloWorldByAlias(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-definition.xml");
		IHelloWorld bean3 = (IHelloWorld)beanFactory.getBean("bean3", IHelloWorld.class);
		bean3.sayHello();
		IHelloWorld alias31 = (IHelloWorld)beanFactory.getBean("alias31", IHelloWorld.class);
		alias31.sayHello();
		IHelloWorld alias32 = (IHelloWorld)beanFactory.getBean("alias32", IHelloWorld.class);
		alias32.sayHello();
	}
	
}
