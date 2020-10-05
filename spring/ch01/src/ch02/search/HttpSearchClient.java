package ch02.search;

public class HttpSearchClient implements SearchClient {

	@Override
	public void addDocument(SearchDocument searchDocument) {
		System.out.println("addDocument()");
	}

	@Override
	public void checkLive() {
		System.out.println("checkLive()");
	}

}
