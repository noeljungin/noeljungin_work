package part4_091;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BillboardTimeMain {

	public static void main(String[] args) {
		String newUrls = "https://www.billboard.com/charts/hot-100";
		String s = "";
		URL url = null;
		
		try {
			url = new URL(newUrls);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream(), "euc-kr"), 8);
			String line = "";
			
			
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
			
			while ((line = reader.readLine()) != null) {
				if (!line.trim().equals("")) {
					if (line.trim().contains("<time datetime=")) {
						s = line.trim();
						s = s.substring(0, s.indexOf(">")-1);
						s = s.substring(s.indexOf("\"")+1).trim();
						break;
						
					}
					
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("Billboard Parsing Error");
		}
		System.out.println("빌보드 차트 날짜 : "+ s);
	}

}
