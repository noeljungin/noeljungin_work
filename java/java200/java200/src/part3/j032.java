package part3;

public class j032 {

	public static void main(String[] args) {
		double latitude1 = 36.2342341;
		double longitude1 = 127.3453452;
		double latitude2 = 35.2342341;
		double longitude2 = 123.234023;
		System.out.println(latitude1 + "\t" + longitude1);
	
		double [] latlng1 = {latitude1, longitude1};
		double [] latlng2 = {latitude2, longitude2};
		System.out.println(latlng1[0] + "\t" + latlng1[1]);
		
		double [][] latlng = {{latitude1, longitude1}, {latitude2, longitude2}};
		System.out.println(latlng[0][0] + "\t" + latlng[0][1]);
		
		
	}

}
