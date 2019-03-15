package part4_093;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import part3_075.RestDay;
import part4_083.Billboard;

public class RequestFromBillboardHot {
	
	ArrayList<String> htmls = new ArrayList<String>();
	ArrayList<Billboard> billboards = new ArrayList<Billboard>();
	boolean isConnection = false;
	
	public RequestFromBillboardHot() {
		htmls.clear();
		billboards.clear();
	}
	
	public ArrayList<Billboard> getBillboards(){
		return billboards;
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
				if(!line.trim().equals("")) {
					htmls.add(line.trim());
				}
			}
			isConnection = true;
		} catch (Exception e) {
			isConnection = false;
			System.out.println("billboard parsing error");
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
					if(line.trim().contains("<time datetime=")) {
						s = line.trim();
						s = s.substring(0, s.indexOf(">")-1);
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
	
	public synchronized void getBillboardData(String msg) {
		billboards.clear();
		for (int i = 0; i < htmls.size(); i++) {
			String ss = htmls.get(i);
			if (ss.contains(msg)) {
				String rank = ss.substring(ss.indexOf("chart-row--")+"chart-row--".length());
				rank = rank.substring(0, rank.indexOf("js")-1).trim();
				String song = ss.substring(ss.indexOf("Song Hover-")+"Song Hover-".length());
				song = song.substring(0, song.indexOf("\"")).trim();
				int j = 1;
				String imageurl = htmls.get(i+j);
				
				while (true) {
					if(imageurl.contains("images/pref_images")) {
						break;
					}
					else {
						j++;
						imageurl = htmls.get(i+j);
					}
				}
				imageurl = imageurl.substring(imageurl.indexOf("https://"));
				imageurl = imageurl.substring(0, imageurl.indexOf("jpg")+".jpg".length());
				int k = 1;
				String artisturl = htmls.get(i+j+k);
				
				while (true) {
					if (artisturl.contains("chart-row__artist")) {
						break;
					} else {
						j++;
						artisturl = htmls.get(i+j+k);
					}
				}
				artisturl = artisturl.substring(artisturl.indexOf("https://"));
				artisturl = imageurl.substring(0, imageurl.indexOf("jpg")+".jpg".length());
				
				k = 1;
				artisturl = htmls.get(i+j+k);
				
				while (true) {
					if (artisturl.contains("chart-row__artist")) {
						break;
					}
					else {
						j++;
						artisturl = htmls.get(i+j+k);
					}
				}
				
				artisturl = artisturl.substring(artisturl.indexOf("https://"));
				artisturl = artisturl.substring(0, artisturl.indexOf("/")+1);
				String artist = artisturl.substring(artisturl.lastIndexOf("/") + 1);
				artist = toArtis(artist);
				
				int m = 1;
				String lastweek = htmls.get(i+j+k+m);
				
				while (true) {
					if (lastweek.contains("chart-row__last-week")) {
						break;
					}
					else {
						j++;
						lastweek = htmls.get(i+j+k+m);
					}
				}
				int n = 1;
				lastweek = htmls.get(i+j+m+n);
				
				while (true) {
					
					if (lastweek.contains("chart-row__value")) {
						break;
					}
					else {
						j++;
						lastweek = htmls.get(i+j+k+m+n);
					}
				}
				
				lastweek = lastweek.substring(lastweek.indexOf(">")+1);
				lastweek = lastweek.substring(0, lastweek.indexOf("<")).trim();
				
				Billboard board = new Billboard(
						toInt(rank), replace(song), 
						toInt(__toStr(lastweek)),
						imageurl, artisturl, artist); 
				billboards.add(board);
				}
			}
		}
	
	public void printHtml() {
		for (String dto : htmls) {
			System.out.println(dto);
		}
	}
	
	public void printBillboard() {
		for (Billboard dto : billboards) {
			System.out.println(dto);
		}
	}
	
	public String replace(String msg) {
		String ss = msg;
		ss = ss.replace("&#039;", "");
		ss = ss.replace("&amp;", "&");
		ss = ss.replace("&quot;", "\"");
		
		return ss.trim();
	}
	
	private String __toStr(String lastweek) {
		return lastweek.contains("--")?101+"":lastweek;
	}
	
	private int toInt(String msg) {
		return Integer.parseInt(msg == null ?"-1":msg.trim());
	}
	
	public String toArtis(String msg) {
		return msg.replaceAll("-", "");
	}

	public static void main(String[] args) {
		RequestFromBillboardHot rfw = new RequestFromBillboardHot();
		String a = "https://www.billboard.com/charts/hot-100";
		String rs = rfw.getTimeDate(a);
		rs = RestDay.toWantedDay(rs, 1);
		System.out.println(rs);
		rfw.getAllHtml(a + rs);
		String str = "<article class=\"chart-row";
		rfw.getBillboardData(str);
		rfw.printBillboard();
		
		
		
	}

}
