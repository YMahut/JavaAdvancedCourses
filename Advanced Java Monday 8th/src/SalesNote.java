import java.util.Comparator;


public class SalesNote extends Saleable implements Comparable, Taxable {
	String date;
	
	
	public SalesNote(String newDate, String newDescription, int newAmount){
		date = newDate;
		description = newDescription;
		amount = newAmount;
	}
	public SalesNote(){
		date = "2015-01-25";
		description = "defaultDescription";
		amount = 4000;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SalesNote [date=" + date + ", description=" + description
				+ ", amount=" + amount + "]";
	}
	
	public int compareTo(SalesNote o1, SalesNote o2) {
			return o1.getDate().compareToIgnoreCase(o2.getDate());
	}
	
	public int tax(){
		int tmp =  this.getAmount() * 25;
		return tmp / 100;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
