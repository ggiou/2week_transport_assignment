public class Taxi extends transport{
	int d= 1; //기본 거리
	int d_fee = 1000; //거리당 요금
	String destination = ""; //목적지
	int distance; //목적지까지 거리
	int pay = 0;
	int pay_sum = 0;
	int max_passenger =4;
	int now_passenger = 0;
	int fee = 3000;
	String status ="일반";
	
	
	public Taxi(){
		start();
		System.out.println("택시 번호 : "+num+"\n");
		
	} //버스 번호 설정;	
	void taxi_current() {
		current(status/*,now_passenger, max_passenger*/);
		/*System.out.println("목적지 = "+destination);
		System.out.println("목적지까지 거리 = "+distance);
		System.out.println("지불할 요금 = "+pay);
		System.out.println("누적 요금 = "+pay_sum+\n);*/

	}
	boolean taxi_pay(boolean change){		
		if(change == true) {
			status = "일반";
			pay_sum += pay;
			pay = 0;
			now_passenger = 0;
			max_passenger = 4;
			destination = "";
			distance = 0;
			System.out.println("누적 요금 = "+pay_sum+"원\n");
		}

		return change;
	} //요금 지불
	
	void Driving_availability() {
		if(!fuel_left()) {
			status = "운행 불가";
			System.out.println("현재 택시 상태 = "+status);	
			//System.out.println("운행이 불가합니다. 현재 택시 요금을 계산 하겠습니다.");
			//taxi_pay(true);
		}
		if(fuel_left()){
			status ="일반";
		}
	}//주유량에 따른 운전 가능 여부
	
	void taxi_speed_change(int acceleration){
		super.speed_change(acceleration);	
	}//속도 변경
	
	
	void taxi_fuel(int fuel){		
		super.refueling(fuel);
		Driving_availability();
	} //택시 주유량 충전
	
	void taxi_ride(int passenger, String destination, int distance){
		if(status.contains("일반")) {
				super.ride(passenger, max_passenger, this.now_passenger);
				if(passenger<(max_passenger-this.now_passenger)) {
					taxi_ride_state(destination, distance);
				}
		}else System.out.println("현재 상태는 "+status+"입니다. 상태를 변경해주세요"+"\n");	
	} //승객 탑승(택시)
	
	
	void taxi_ride_state(String destination, int distance) {	
			pay = fee +((distance-d)*d_fee);
			status = "운행 중";
			System.out.println("기본 요금 확인 = "+fee+"원");
			System.out.println("목적지 = "+destination);
			System.out.println("목적지까지 거리 = "+ distance+"km");
			System.out.println("지불할 요금 = "+ pay+"원");
			System.out.println("상태 = "+ status+"\n");
	}	
}
