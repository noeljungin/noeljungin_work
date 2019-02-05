package part2;

class JLocation {
	public double lat;
	public double lng;
}
//사용자 정의 참조 사용하기
public class j017 {

	public static void main(String[] args) {
		double latitude=37.5234124123;
		double longitude=127.23423412;
		
		//사용자 정의 객체 생성
		JLocation jloc = new JLocation();
		jloc.lat = latitude;
		jloc.lng = longitude;
		
		JLocation newLoc = jloc;
		System.out.println(newLoc.lat);
	}

}
