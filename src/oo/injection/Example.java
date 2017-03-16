package oo.injection;

import java.util.HashMap;

/*
 * ����ע��
 * ����ͨ��ע��ķ�ʽ��֯��������ܶ�ҵ�����������(������ת)
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
		//�������װ�䣬���������ļ�ʵ��
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