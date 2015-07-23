package nust.cs.vmxplus.chapter04.instance;

public class HelloWorldInstanceFactory {
	
	public IHelloWorld newInstance(String message){
		//需要返货的Bean实例
		return new HelloWorldImpl(message);
	}
}
