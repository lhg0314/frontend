package singleton;

public class Singleton_02 {
	
	//단점 보완(해결)
	//1.인스턴스를 생성할때 추가작업을 할수 없다
	//->예외처리 불가
	

	public String data ="Apple";//데이터
	
	
	//private생성자-클래스 외부에서객체 생성하지 못하게 막는다
	private Singleton_02() {
		
	}

	//자신 클래스에 대한 객체 생성
	private static Singleton_02 instance;
	
	//static 초기화 블록
	//클래스 변수를 초기화하는 블록
	//정적 변수도 try catch를 하려면 static블록안에 넣어야한다
	static {
		instance=new Singleton_02();//객체 생성
	}
	
	//싱그톤 객체 반환 메소드
	public static Singleton_02 getInstance() {
		return instance;
	}
}
