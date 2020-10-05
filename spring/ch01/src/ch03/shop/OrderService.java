package ch03.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ch02.erp.ErpClient;
import ch02.erp.ErpClientFactory;
import ch02.erp.ErpOrderData;
import ch02.search.SearchClientFactory;
import ch02.search.SearchDocument;

@Component
public class OrderService {

	private ErpClientFactory erpClientFactory;
	private SearchClientFactory searchClientFactory;

	@Autowired
	public void setErpClientFactory(ErpClientFactory erpClientFactory) {
		this.erpClientFactory = erpClientFactory;
	}

	@Autowired
	public void setSearchClientFactory(@Qualifier("order") SearchClientFactory searchClientFactory) {
		this.searchClientFactory = searchClientFactory;
	}

	public void order(OrderInfo oi) {
		sendOrderInfoToErp(oi);
		addOrderInfoToSearch(oi);
	}

	private void sendOrderInfoToErp(OrderInfo oi) {
		ErpClient erpClient = erpClientFactory.create();
		erpClient.connent();
		erpClient.sendPhrchaseInfo(toErpOrderData(oi));
		erpClient.close();
	}

	private ErpOrderData toErpOrderData(OrderInfo oi) {
		return new ErpOrderData();
	}

	private void addOrderInfoToSearch(OrderInfo oi) {
		searchClientFactory.create().addDocument(toSearchDocument(oi));
	}

	private SearchDocument toSearchDocument(OrderInfo oi) {
		return new SearchDocument();
	}

}
