package ch02.erp;

public interface ErpClient {
	
	public void connent();
	public void close();
	public void sendPhrchaseInfo(ErpOrderData oi);
}
