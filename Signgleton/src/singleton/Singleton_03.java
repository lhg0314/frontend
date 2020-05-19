package singleton;

//단점 보완
//1.인스턴스를 생성할때 추가작업을 할수 없다
//->예외처리 불가

//2.인스턴스 객체를 사용하지 않아도 생성해 놓는다

public class Singleton_03 {
	

	public String data ="Apple";//데이터
	
	
	//private생성자-클래스 외부에서객체 생성하지 못하게 막는다
	private Singleton_03() {
		
	}

	//자신 클래스에 대한 객체 생성
	private static Singleton_03 instance;
	
	//싱그톤 객체 반환 메소드
	public static Singleton_03 getInstance() {
		
		//getInstance() 를 처음 호출할 때까지 객체 생성을 하지 않고 
		//기다린다
		
		//두번째 호출부터는 만들어져있는 객체를 반환한다
		
		if(instance ==null) {
			try {
				instance=new Singleton_03();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
