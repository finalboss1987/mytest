package oo.factory;

/*
 * 静态工厂
 * 优势： 将变化控制在较小范围，具体依赖到了工厂方法
 * 缺点： 创建对象的方法与其他静态方法没有不同
 */


public class Example {

	public static void main(String[] args) {
		Television tv = new Television();
		tv.playVideo();
	}

}

class PanelFactory {
	public static Panel createLcdPanel() {
		return new LcdPanel();
	}
}


interface Panel {
	public void display();
}

class Television {
	private Panel panel = PanelFactory.createLcdPanel();
	
	public void playVideo() {
		panel.display();
	}
}

class LcdPanel implements Panel {
	public void display() {
		System.out.println("Lcd Panel display!");		
	}	
}