package teamProject3;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class Books {
	String title;
	Date idate;
	String writer;
	String publisher;
	int price;
	String isbn;
	String category;

	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Books(String title, String idate, String writer, String publisher, String price, String isbn,
			String category) {
		this.title = title;
		try {
			this.idate = sf.parse(idate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.writer = writer;
		this.publisher = publisher;
		this.price = Integer.parseInt(price);
		this.isbn = isbn;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getIdate() {
		return idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {

		return String.format("%-11.11s", title) + "\t\t" + category + "\t" + price + "\t" + String.format("%-5.5s", writer)
				+ "\t" + String.format("%-5.5s", publisher) + "\t" + sf.format(idate) + "\t" + isbn + ";";
	}

	public String toTxt(Date today) {
		return title + "\t" +  sf.format(idate) + "\t" + writer + "\t" + publisher + "\t" + price + "\t" + isbn + "\t" 
					+ category + "\t" +  sf2.format(today) + "\r\n";
	}


}
