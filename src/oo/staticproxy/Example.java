package oo.staticproxy;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * ��̬����
 * ��������ҵ�����ʵ����ͬ�Ľӿ�
 * �ϲ���벻��Ҫ֪������ʵ��
 */

public class Example {

	public static void main(String[] args) {
		HelloService service = new HelloServiceProxy(new HelloServiceImpl());
		service.hello("Michael");
	}

}

interface HelloService {
	public void hello(String name);
}

class HelloServiceImpl implements HelloService {
	public void hello(String name)  {
		System.out.println("hello, " + name);
	}
}

class HelloServiceProxy implements HelloService{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private HelloService service;
	
	public HelloServiceProxy(HelloService service) {
		this.service = service;
	}
	
	public void hello(String name) {
		logger.log(Level.INFO, "hello method start...");
		service.hello(name);
		logger.log(Level.INFO, "hello method end...");
	}
}