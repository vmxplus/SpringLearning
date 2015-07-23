package nust.cs.vmxplus.chapter04.instance;

public class HelloWorldImpl implements IHelloWorld {
	String message;
	
	/**
	 * 空构造器
	 */
	public HelloWorldImpl(){
		this.message = "Hello World!";
	}
	/**
	 * 带参数的构造器 
	 * @param message
	 */
	public HelloWorldImpl(String message){
		this.message = message;
	}
	
	@Override
	public void sayHello() {
		System.out.println(message);
	}

}
