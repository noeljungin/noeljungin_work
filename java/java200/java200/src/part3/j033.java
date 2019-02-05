package part3;

public class j033 {

	public static void main(String[] args) {
		double latitude1 = 37.8234241;
		double longitude1 = 127.2348234;
		double latitude2 = 35.2411234;
		double longitude2 = 129.2342341;
		
		Geo geo1 = new Geo();
		
		geo1.latitude = latitude1;
		geo1.longitude = longitude1;
		
		System.out.println(geo1.latitude + "\t" + geo1.longitude);
		
		Geo geo2 = new Geo();
		geo2.latitude = latitude2;
		geo2.longitude = longitude2;
		
		Geo geo = geo1;
		System.out.println(geo.latitude + "\t" + geo.longitude);

	}

}
