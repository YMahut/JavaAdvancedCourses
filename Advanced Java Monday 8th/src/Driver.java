public class Driver{
    public void Driver(){}
    
    static public void test(){
    
	    SalesNote sn1 = new SalesNote("2016-01-01", "A4 paper", 200);
	    SalesNote sn2 = new SalesNote();
	    
	    System.out.println(sn1.toString());
	    System.out.println(sn2.toString());
    
	    SalesPerson salesPerson = new SalesPerson();
	    
	    salesPerson.addSalesNote(sn1);
	    salesPerson.addSalesNote(sn2);
	    
	    System.out.println(salesPerson.poorestSale().toString());
	    System.out.println(salesPerson.totalSales());
	    
	    System.out.println("----------------------");
	    //salesPerson.printSales();
	    
	    System.out.println(sn1.tax());

	    ConsultantHours cons1 = new ConsultantHours();
	    
	    cons1.getAmount();
	    
    }

}
