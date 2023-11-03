package kr.co.itwill;

import javax.swing.JOptionPane;

public class MessageEN implements IHello {

	public void MessageEn() {
		System.out.println("MessageEn 호출됨");
	}//end
	
	@Override
	public void sayHello(String name) {
		JOptionPane.showMessageDialog(null, "Hello~~" + name);
	}//end

	
	
	
}//class end
