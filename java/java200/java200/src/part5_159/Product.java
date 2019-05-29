package part5_159;

public class Product {
	private int prodNum;
	private String prodPart;
	private String pName;
	private int pValue;
	private int pAmont;
	private String pPant;
	private String pConsum;
	private int pPoint;
	private int pCount;
	private int pMoney;
	private String pGrade;
	
	public void setProduct(String[] s) {
		this.setProdNum(Integer.parseInt(s[0].trim()));
		this.setProdPart(s[1].trim());
		this.setPName(s[2].trim());
		this.setPValue(Integer.parseInt(s[3].trim()));
		this.setPAmount(Integer.parseInt(s[4].trim()));
		this.setPPant(s[5].trim());
		this.setPConsum(s[6].trim());
		this.setPPoint(Integer.parseInt(s[7].trim()));
		this.setPCount(Integer.parseInt(s[8].trim()));
		this.setPMoney(Integer.parseInt(s[9].trim()));
		this.setPGrade(s[10].trim());
	}
	public String toString() {
		
	}
}
