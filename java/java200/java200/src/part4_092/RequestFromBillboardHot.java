package part4_092;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import part3.j062;

public class RequestFromBillboardHot {
	ArrayList<String> htmls = new ArrayList<String>();
	boolean isConnection = false;
	
	public RequestFromBillboardHot() {
		htmls.clear();
	}
	
	public void getAllHtml(String newUrls) {
		htmls.clear();
		URL url = null;
		
		try {
			url = new URL(newUrls);
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream(), "euc-kr"), 8);
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				
				if (!line.trim().equals("")) {
					htmls.add(line.trim());
				}
			}
			isConnection = true;
		} catch (Exception e) {
			isConnection = false;
			System.out.println("Billboard Parsing error");
		}
	}
	
	public void printHtml() {
		for (String ss : htmls) {
			System.out.println(ss);
		}
	}
	
	public String getTimeDate(String newUrls) {
		String s = "";
		URL url = null;
		
		try {
			url = new URL(newUrls);
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream(), "euc-kr"), 8);
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				
				if (!line.trim().equals("")) {
					if (line.trim().contains("<time datetime=")) {
						s = line.trim();
						s = s.substring(0, s.indexOf(">") -1);
						s = s.substring(s.indexOf("\"")+1).trim();
						break;
					}
				}
			}
			isConnection = true;
		} catch (Exception e) {
			isConnection = false;
			System.out.println("billboard parsing error");
		}
		return s;
	}
	
	public static void main(String[] args) {
		RequestFromBillboardHot rfw = new RequestFromBillboardHot();
		String a = "https://www.billboard.com/charts/hot-100";
		String rs = rfw.getTimeDate(a);
		System.out.println("this week" + rs);
		rs = j062.toWantedDay(rs, 1);
		System.out.println("one week" + rs);
		System.out.println(rs);
		rfw.getAllHtml(a + rs);
		rfw.printHtml();
	}
	
	
	
}
