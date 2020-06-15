package ch08;

public class Exam3 {

	public static void main(String[] args) {
		try {
			throw new UnsupportFunctionException("지원하지 않는 기능입니다 ", 200);
		} catch (UnsupportFunctionException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrCode());
		}
	}
	
}

class UnsupportFunctionException extends RuntimeException {
	private final int ERR_CODE;
	
	UnsupportFunctionException(String msg, int ERR_CODE) {
		super(msg);
		this.ERR_CODE = ERR_CODE;
	}
	
	
	public int getErrCode() {
		return ERR_CODE;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + ", 오류코드 : " + ERR_CODE;
	}
}


