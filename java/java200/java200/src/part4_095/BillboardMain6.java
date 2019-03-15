package part4_095;

import part4_093.RequestFromBillboardHot;

public class BillboardMain6 {

	public static void main(String[] args) {
		RequestFromBillboardHot rfw=new RequestFromBillboardHot();
		String a="https://www.billboard.com/charts/hot-100/";
		String rs=rfw.getTimeDate(a);
		rfw.getBillboardData(a+rs);
		rfw.printBillboard();

		//BillboardPrint.printToCSV(rfw.getBillboards(), "billboard\\"+rs+".csv");
		BillboardPrint.printTOJSON(rfw.getBillboards(), "billboard\\"+rs+".json");
		//BillboardPrint.printToXML(rfw.getBillboards(), "billboard\\"+rs+".xml");
	}

}
