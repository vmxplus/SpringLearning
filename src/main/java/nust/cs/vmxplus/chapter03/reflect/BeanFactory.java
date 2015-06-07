package nust.cs.vmxplus.chapter03.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.*;
import org.dom4j.io.SAXReader;





public class BeanFactory {
	private Map<String, Object> beanMap = new HashMap<String, Object>();
	
	/**
	 * bean 工厂的初始化.
	 * 
	 * @param
	 */
	
	public void init(String xml){
		try {
			//1创建读取配置文件的reader对象
			SAXReader reader = new SAXReader();
			
			//2.获取当前线程中的类装载器对象
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			
			//3.从class目录下获取指定的xml文件
			InputStream ins = classLoader.getResourceAsStream(xml);
			
			
			Document doc = reader.read(ins);
			
			Element root = doc.getRootElement();
			Element foo;
			
			//4.遍历xml文件当中的Bean实例
			for(Iterator i = root.elementIterator("bean"); i.hasNext();){
				foo = (Element)i.next();
				
				//5.针对每一个Bean实例，获取bean的属性id和class
				Attribute id = foo.attribute("id");
				Attribute cls = foo.attribute("class");
				
				//6.利用java反射机制，通过class名称获取Class对象
				Class bean = Class.forName(cls.getText());
				
				//7.获取class的信息
				java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
				
				//8.获取属性描述
				java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
				
				//9.创建一个对象， 并在接下来的代码中卫对象属性赋值
				Object obj = bean.newInstance();
				
				//10.遍历该bean的property属性
				for(Iterator ite = foo.elementIterator("property"); ite.hasNext();){
					Element foo2 = (Element) ite.next();
					
					//11.获取该property的name属性
					Attribute name = foo2.attribute("name");
					String value = null;
					
					
					//12.获取该property的子元素value值
					for(Iterator itel = foo2.elementIterator("value"); itel.hasNext();){
						Element node = (Element) itel.next();
						value = node.getText();
						break;
					}
					
					//13.利用Java的反射机制调用对象的某个set方法，并将值设置进去
					for (int k = 0; k < pd.length; k++) {
						if (pd[k].getName().equalsIgnoreCase(name.getText())) {
							Method mSet =null;
							mSet = pd[k].getWriteMethod();
							mSet.invoke(obj, value);
						}
					}
				}
				
				beanMap.put(id.getText(), obj);
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}	
	}
	
	
	private Object getBean(String string) {
		Object object = beanMap.get(string);
		return object;
	}
	
	
	
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		
	

		factory.init("config.xml");
		JavaBean javaBean = (JavaBean) factory.getBean("javaBean");
		
		System.out.println("userName=" + javaBean.getUserName());
		System.out.println("password=" + javaBean.getPassword());
	}

	
}
