package oo.globalregistry;

import java.util.HashMap;

/*
 * 全局注册表
 * J2EE大量使用该方法
 */

public class Example {

	public static void main(String[] args) {
		GlobalRegistry.registerService("Panel", new LcdPanel());
		Television tv =  new Television();
		tv.playVideo();
	}

}

class GlobalRegistry {
	private static final HashMap<String, Object> services = new HashMap<String, Object>();
	
	public static Object getService(String serviceName) {
		return services.get(serviceName);
	}
	
	public static void registerService(String serviceName, Object service) {
		services.put(serviceName, service);
	}
}


interface Panel {
	public void display();
}

class Television {
	private Panel panel = (Panel)GlobalRegistry.getService("Panel");
	
	public void playVideo() {
		panel.display();
	}
}

class LcdPanel implements Panel {
	public void display() {
		System.out.println("Lcd Panel display!");		
	}	
}