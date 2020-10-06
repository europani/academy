package ch03.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch02.search.SearchClientFactory;

public class MainForShop {

	public static void main(String[] args) {
//		runByUsingXmlConfig();
//		runByUsingJavaConfig();
//		runByUsingXmlConfigScan();
		runByUsingJavaConfigScan();
	}

	private static void runByUsingXmlConfig() {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch03/shop/config-shop.xml");
		useBean(ctx);
	}

	private static void runByUsingJavaConfig() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigShop.class);
		useBean(ctx);
	}

	private static void runByUsingXmlConfigScan() {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch03/shop/config-shop-scan.xml");
		useBean(ctx);
	}

	private static void runByUsingJavaConfigScan() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigShopScan.class);
		useBean(ctx);
	}

	private static void useBean(ApplicationContext ctx) {
		ProductService productService = ctx.getBean(ProductService.class);
		productService.createProduct(new ProductInfo());

		OrderService orderService = ctx.getBean(OrderService.class);
		orderService.order(new OrderInfo());

		SearchClientFactory orderSearchClientFactory = ctx.getBean("orderSearchClientFactory",
				SearchClientFactory.class);
		System.out.println(orderSearchClientFactory);
		SearchServiceHealthChecker healthChecker = ctx.getBean(SearchServiceHealthChecker.class);
		healthChecker.check();
	}

}
