public class Bus extends transport{	
	int max_passenger = 30;
	int now_passenger = 0;
	int fee = 1000;
	String status = "운행";
	int fuel_current = super.fuel_current;

	public Bus(){
		start();
		System.out.println("버스 번호 : "+num+"\n");
	} //버스 번호 설정;
	
	void bus_current() {
		current(status/*,now_passenger,max_passenger*/);
	}
	
	boolean bus_change(boolean change){		
		if(change == true) { 	
			if(fuel_left()) {
				if(!status.contains("운행"))	status = "운행";
				else {
					status = "차고지 행";
					now_passenger = 0;
					max_passenger = 30;
					System.out.println("현재 버스 상태 = "+status+"\n");
				}
			}
			if(!fuel_left())System.out.println("주유 필요\n");
		}
	    //System.out.println("현재 버스 상태 = "+status+"\n");
		return change;
	} // 버스 상태 변경
	
	void Driving_availability() {
		if(!fuel_left()) {
			status = "차고지 행";	
			now_passenger = 0;
			max_passenger = 30;
			System.out.println("현재 버스 상태 = "+status+"\n");		
		}
		if(fuel_left()){
			//System.out.println("운행 가능");		
		}
	}//주유량에 따른 운전 가능 여부
	
	void bus_speed_change(int acceleration){
		super.speed_change(acceleration);	
	}//속도 변경
	
	void bus_fuel(int fuel){		
		super.refueling(fuel);
		Driving_availability();
	} //버스 주유량 충전
	
	void bus_ride(int passenger){
		if(status.contains("운행")) {
			super.ride(passenger, max_passenger, now_passenger);
			if(passenger<(this.max_passenger-this.now_passenger)) {
				System.out.println("요금 확인 = "+fee*passenger+"원\n");
				}
		}else System.out.println("현재 상태는 "+status+"입니다. 상태를 변경해주세요"+"\n");
	} //승객 탑승(버스)

}
