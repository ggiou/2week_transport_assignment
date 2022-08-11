public class transport  {
	String status;
	int num; 
	void start() {
		num = (int)(Math.random()*100+1);
	}//운행 시작
	
	boolean change; //상태 변경
	
	void current(String status/*,int now_passenger, int max_passenger */){
		System.out.println("번호 = "+num);
		System.out.println("현재 상태 = "+status);
		System.out.println("현재 주유량 = "+fuel_current+"\n");
		/*System.out.println("현재 승객 수 = "+now_passenger);
		System.out.println("최대 승객 수  = "+max_passenger);*/
	} //현재 상태 확인
//---------------기본---------------
	int fuel_current=100; //현재 주유량
	int fuel; //추가할 주유량
	
	boolean fuel_left() {
		if(fuel_current >= 10) return true;
		else return false;
	} //주유량 남은 상태 설정
	
	public int refueling(int fuel){
		//System.out.println("충전 할 주유량은 "+fuel+" 입니다.");
		fuel_current += fuel;
		
		if(fuel_left()) {
			 //System.out.println("운행 가능할 정도의 연료가 있습니다.");
		 }
		 else if(!fuel_left()) {
			 System.out.println("주유 필요\n");
		 }; 
		 System.out.println("주유량 = "+fuel_current+"\n");
		 
		 return fuel_current;		
	}//주유량 충전
//---------------주유---------------
	
	int speed = 0; //속도
	int currentspeed =0;
	int acceleration;
	
    public int speed_change(int acceleration){
		if(fuel_left()) {
				this.acceleration = acceleration; //가속도 이 안에서 사용
				currentspeed +=acceleration;
				System.out.println("현재 속도는 "+currentspeed+" 입니다.");							
			}
			System.out.println("주유량을 확인해 주세요. 현재 "+fuel_current+" 남았습니다.\n");
			return fuel_current;		
	}//속도 변경 기능
    
//---------------속도---------------
	
    int max_passenger;//최대 승객 수
    int passenger; //들어올 승객 수
	int now_passenger=0;
	int fee;
	
	boolean available(int passenger, int max_passenger, int now_passenger) {
		if(passenger>max_passenger-now_passenger) {
			System.out.println("최대 승객 수 초과\n");
			return false;
		}else return true; 
	}//최대 승객 수 초과
	
	public int ride(int passenger, int max_passenger, int now_passenger){
		if(passenger>(max_passenger-now_passenger)) { 
			System.out.println("최대 승객 수 초과\n");			
		}
		else {
			if(available(passenger,max_passenger, now_passenger)) {
				now_passenger += passenger;
		
				System.out.println(num+"번 탑승 승객 수 = "+now_passenger);
				System.out.println("잔여 승객 수 = "+(max_passenger-now_passenger));
			}
			else if(!available(passenger, max_passenger, now_passenger));
		}
		return now_passenger;
	}// 승객 탑승
	
//---------------승객---------------	
}
