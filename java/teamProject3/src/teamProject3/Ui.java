package teamProject3;
class Ui {
	static void mainUi() {
		System.out.println("원하는 메뉴를 입력해주세요.[종료 : 0]");
		System.out.println("1.도서 조회"); 		//전체, 제목, 주제별, 작가별, 출판사 별
		System.out.println("2.도서 구입");			//장바구니
		System.out.println("3.구매 리스트");		
		System.out.println("4.회원가입"); 	
		System.out.println("5.로그인");
	}
	static void mainUi1() {
		System.out.println(">>도서 조회 [이전메뉴:0]");
		System.out.println("1.전체 도서 조회");
		System.out.println("2.주제별 조회");
		System.out.println("3.발행년도별 조회");
	}
	
	static void mainUi2() {
		System.out.println(">>도서 구매 [이전메뉴:0]");
		System.out.println("1.전체 검색");
		System.out.println("2.제목으로 검색");
		System.out.println("3.주제로 검색");
		
	}
	
}