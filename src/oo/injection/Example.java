package oo.injection;

import java.util.HashMap;

/*
 * 对象注入
 * 对象通过注入的方式组织起来，框架对业务代码无侵入(依赖反转)
 */

public class Example {

	public static void main(String[] args) {
		Context context = new Context();
		Television tv =  (Television)context.getService("Television");
		tv.playVideo();
	}

}

class Context {
	private final HashMap<String, Object> services = new HashMap<String, Object>();
	
	public Context() {
		//各个组件装配，可用配置文件实现
		LcdPanel panel = new LcdPanel();
		registerService("Panel",panel);
		
		Television tv = new Television();
		tv.setPanel(panel);
		registerService("Television",tv);
	}
	
	public Object getService(String serviceName) {
		return services.get(serviceName);
	}
	
	public void registerService(String serviceName, Object service) {
		services.put(serviceName, service);
	}
}


interface Panel {
	public void display();
}

class Television {
	private Panel panel;
	
	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	
	public void playVideo() {
		panel.display();
	}
}

class LcdPanel implements Panel {
	public void display() {
		System.out.println("Lcd Panel display!");		
	}	
}