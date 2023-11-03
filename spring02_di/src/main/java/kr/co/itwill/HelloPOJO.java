package kr.co.itwill;

public class HelloPOJO {

	public static void main(String[] args) {
		// POJO {plain Old Java Object
		// new 연산자를 활용한 객체 생성
		
		IHello hello = null;
		
		hello = new MessageKO(); //POJO방식의 객체 생성
		hello.sayHello("손흫민");
		
		
		
		
		
		
		
	}//main() end
}//class end
