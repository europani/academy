package ch03.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ch02.search.SearchClientFactory;
import ch02.search.SearchDocument;

@Component
public class ProductService {

	private SearchClientFactory searchClientFactory;
	
	@Resource(name = "productSearchClientFactory")
	public void setSearchClientFactory(SearchClientFactory searchClientFactory) {
		this.searchClientFactory = searchClientFactory;
	}
	
	public void createProduct(ProductInfo pi) {
		searchClientFactory.create().addDocument(toSearchDocument(pi));
	}
	
	private SearchDocument toSearchDocument(ProductInfo pi) {
		return new SearchDocument();
	}
}
