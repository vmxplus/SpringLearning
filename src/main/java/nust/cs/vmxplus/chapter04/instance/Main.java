package nust.cs.vmxplus.chapter04.instance;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
	public static void main(String[] args) {
		
		sayHelloWorldWithNoArgs();
		sayHelloWorldWithArgs();
		sayHelloWorldWithStaticFactory();
		sayHelloWorldWithInstanceFactory();
	}
	
	public static void sayHelloWorldWithNoArgs(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-instance.xml");
		
		IHelloWorld ihelloWorld = beanFactory.getBean("helloWorldWithNoArgs", IHelloWorld.class);
		ihelloWorld.sayHello();
	}
	public static void sayHelloWorldWithArgs(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-instance.xml");
		
		IHelloWorld ihelloWorld = beanFactory.getBean("helloWorldWithArgs", IHelloWorld.class);
		ihelloWorld.sayHello();
	}
	
	public static void sayHelloWorldWithStaticFactory(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-instance.xml");
		
		IHelloWorld ihelloWorld = beanFactory.getBean("helloWorldStaticFactory", IHelloWorld.class);
		ihelloWorld.sayHello();
	}
	
	public static void sayHelloWorldWithInstanceFactory(){
		BeanFactory beanFactory =
				new ClassPathXmlApplicationContext("conf-instance.xml");
		
		IHelloWorld ihelloWorld = beanFactory.getBean("helloWorldInstance", IHelloWorld.class);
		ihelloWorld.sayHello();
	}
	

	
}
