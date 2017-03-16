package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * ��̬����
 * һ������������������
 * AOP������ aspect-oriented programming
 * ����ɢ��ͨ�ù��ܰ����������
 */


public class Example {

	public static void main(String[] args) {
		HelloService service = (HelloService) LogHandler.createProxy(new HelloServiceImpl());
		service.hello("Michael");
		service.bye("Tom");
	}

}



interface HelloService {
	public void hello(String name);
	public void bye(String name);
}

class HelloServiceImpl implements HelloService {
	public void hello(String name)  {
		System.out.println("hello, " + name);
	}

	public void bye(String name) {
		System.out.println("bye, " + name);
	}
}

class LogHandler implements InvocationHandler {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object delegate;
	
	private LogHandler(Object delegate) {
		this.delegate = delegate;
	}
	
	public static Object createProxy(Object delegate) {
		return Proxy.newProxyInstance(//
				delegate.getClass().getClassLoader(),//
				delegate.getClass().getInterfaces(),//
				new LogHandler(delegate));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			logger.log(Level.INFO, method + " start...");
			Object result = method.invoke(delegate, args);
			logger.log(Level.INFO, method + " end...");
			return result;
		} catch (Exception e) {
			logger.log(Level.WARNING, "Error: " + e.getMessage());
			throw e;
		}
	}
	
}