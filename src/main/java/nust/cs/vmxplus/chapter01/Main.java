package nust.cs.vmxplus.chapter01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;



public class Main {
	public static void main(String[] args) {
		Resource r = new FileSystemResource("helloMessage.xml");
		BeanFactory f = new XmlBeanFactory(r);
		Person person  = (Person) f.getBean("person");
		String s = person.sayHello();
		System.out.print("The person is currently saying " + s);
	}
}
