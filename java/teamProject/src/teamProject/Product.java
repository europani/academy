package teamProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Product {
	String category;
	String item;
	Date idate;
	int qty;
	String itemcode;
	
	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	
	Product(String category, String item, String idate, String qty, String itemcode) {
		this.category = category;
		this.item = item;
		try {
			this.idate = sf.parse(idate);		// String->Date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.qty = Integer.parseInt(qty);		// String -> int
		this.itemcode = itemcode;
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getIdate() {
		return idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public SimpleDateFormat getSf() {
		return sf;
	}

	public void setSf(SimpleDateFormat sf) {
		this.sf = sf;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", item=" + item + ", idate=" + sf.format(idate) + ", qty=" + qty + ", itemcode="
				+ itemcode + "]";
	}

	public String toTxt() {
		return category + ", " + item + ", " + sf.format(idate) + ", " + qty + ", " + itemcode +  "\r\n";
	}
	
	
	

}
