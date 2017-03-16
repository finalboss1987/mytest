package oo.factory;

/*
 * ��̬����
 * ���ƣ� ���仯�����ڽ�С��Χ�������������˹�������
 * ȱ�㣺 ��������ķ�����������̬����û�в�ͬ
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