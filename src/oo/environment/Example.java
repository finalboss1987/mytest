package oo.environment;

/*
 * 环境变量
 * 优点：灵活通过启动配置改变接口的实现
 * 缺点：使用反射
 */


public class Example {

	public static void main(String[] args) {
		System.setProperty("panel.impl.class", "oo.environment.CrtPanel");
		Television tv = new Television();
		tv.playVideo();
	}

}

class PanelFactory {
	private static final String DEFAULT_PANEL = "oo.environment.LcdPanel";
	
	public static Panel createPanel() {
		String panel = System.getProperty("panel.impl.class");
		if (panel == null) {
			panel = DEFAULT_PANEL;
		}
		try {
			//forName会调用静态代码块，loadClass不会
			Class<?> panelClass = PanelFactory.class.getClassLoader().loadClass(panel);
			//Class<?> panelClass = Class.forName(panel);
			return (Panel)panelClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}


interface Panel {
	public void display();
}

class Television {
	private Panel panel = PanelFactory.createPanel();
	
	public void playVideo() {
		panel.display();
	}
}

class LcdPanel implements Panel {
	public void display() {
		System.out.println("Lcd Panel display!");		
	}	
	
}

class CrtPanel implements Panel {
	public void display() {
		System.out.println("Crt Panel display!");		
	}	
}