import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections.*;
import java.util.Comparator.*;


public class SalesPerson {
	
	String name;
	ArrayList<SalesNote> salesNoteList;
	
	public SalesPerson(){
		name = "defaultName";
		salesNoteList = new ArrayList();
	}
	
	public SalesPerson(String newName){
		name = newName;
		salesNoteList = new ArrayList();
	}
	
	public void addSalesNote(SalesNote sn){
		salesNoteList.add(sn);
	}
	
	public void removeSalesNote(SalesNote sn){
		salesNoteList.remove(sn);
	}
	
	public SalesNote poorestSale(){
		int tmp;
		SalesNote res;
		res = null;
		tmp = 0;
		for (SalesNote s : salesNoteList)
			if (tmp <= s.getAmount()){
				res = s;
			}
			
		return res;
	}
	
	public int totalSales(){
		int tmp =0;
		for (SalesNote s : salesNoteList)
			tmp = tmp + s.getAmount();
			
		return tmp;
	}
	
//	public void printSales(){
//		Collections.sort(salesNoteList);
//		for (SalesNote s : salesNoteList)
//			s.parse();
//		for (SalesNote s : salesNoteList)
//			System.out.println(s.toString());		
//	}
	
}