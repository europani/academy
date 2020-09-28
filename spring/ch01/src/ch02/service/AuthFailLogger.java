package ch02.service;

public class AuthFailLogger {
	private int threshold;
	private int failCounts;
	
	public void insertBadPw(String id, String password) {
		System.out.printf("AuthFail [type=padpw, userid=%s, pw=%s]\n", id, password);
		failCounts++;
		if (threshold > 0 && failCounts > threshold) {
			notifyTooManyFail();
			failCounts = 0;
		}
	}

	private void notifyTooManyFail() {
		System.out.println("너무 많은 로그인 시도 실패");
	}
	
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
}
