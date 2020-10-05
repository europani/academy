package ch03.shop;

import java.util.List;

import ch02.search.SearchClient;
import ch02.search.SearchClientFactory;

public class SearchServiceHealthChecker {

	private List<SearchClientFactory> factories;
	
	public void setFactories(List<SearchClientFactory> factories) {
		this.factories = factories;
	}
	
	public void check() {
		for (SearchClientFactory factory : factories) {
			SearchClient searchClient = factory.create();
			searchClient.checkLive();
		}
	}
}
