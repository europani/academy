package ch02.erp;

import java.util.Properties;

public class DefaultErpClientFactory extends ErpClientFactory {

	private String server;
	
	public DefaultErpClientFactory(Properties props) {
		this.server = props.getProperty("server");
	}
	@Override
	public ErpClient create() {
		return new ErpClient() {
			
			@Override
			public void connent() {
				System.out.println("������ : " + server);					
			}
			
			@Override
			public void close() {
				System.out.println("������� : " + server);				
			}

			@Override
			public void sendPhrchaseInfo(ErpOrderData oi) {
				System.out.println("�ֹ� ���� ���� : " + server);
			}
		};
	}

}
