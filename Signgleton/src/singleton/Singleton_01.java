package singleton;

public class Singleton_01 {
	
	//단점
	//1.인스턴스를 생성할때 추가작업을 할수 없다
	//->예외처리 불가
	
	//2.인스턴스 객체를 사용하지 않아도 생성해 놓는다

	public String data ="Apple";//데이터
	
	
	//private생성자-클래스 외부에서객체 생성하지 못하게 막는다
	private Singleton_01() {
		
	}

	//자신 클래스에 대한 객체 생성
	private static Singleton_01 instance=new Singleton_01();
	
	//싱그톤 객체 반환 메소드
	public static Singleton_01 getInstance() {
		return instance;
	}
}
