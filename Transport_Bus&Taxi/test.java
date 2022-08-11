/* 기능 설명
   _current() : 현재 상태 출력
   _speed_change(acceleration) : acceleration값 만큼의 속도 변경
   _fuel(fuel): fuel 만큼의 주유량 충전
   
   bus_change(boolean) : boolean의 값이 true 면 버스 상태 변경
   bus_ride(passenger) : passenger 만큼의 승객 추가
   
   taxi_pay(boolean) : 요금 지불 및 택시 상태 일반
   taxi_ride(passenger, destination, distance) : 승객 추가, 목적지, 목적지가지의 거리로 택시 운행
 */

public class test {
	public static void main(String[] args) {
		System.out.println("================================\n버스\n");
		Bus bus1 = new Bus();
		Bus bus2 = new Bus();
			
		bus1.bus_ride(2);
		bus1.bus_fuel(-50);

		bus1.bus_change(true);
		bus1.bus_fuel(10);
		bus1.bus_change(true);
		bus1.bus_ride(45);
		bus1.bus_ride(5);
		bus1.bus_fuel(-55);
		
		System.out.println("================================\n택시\n");
		Taxi taxi1 = new Taxi();
		Taxi taxi2 = new Taxi();
		taxi1.taxi_current();
		taxi2.taxi_current();
		
		taxi1.taxi_ride(2,"서울역", 2);
		taxi1.taxi_fuel(-80);
		taxi1.taxi_pay(true);
		taxi1.taxi_ride(5,"잠실역", 22);
		taxi1.taxi_ride(3,"구로디지털단지역", 12);
		taxi1.taxi_fuel(-20);
		taxi1.taxi_pay(true);
		
	}
		
}
