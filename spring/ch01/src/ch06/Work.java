package ch06;

public class Work {
	public static enum WorkType{
		SINGLE
	}

	private Long timeout;
	private WorkType type;
	private long order;
	
	public long getOrder() {
		return order;
	}
	public void setOrder(long order) {
		this.order = order;
	}
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	public void setType(WorkType type) {
		this.type = type;
	}
	public void run() {
		System.out.printf("Work[timeout=%d, type=%s, order=%d] executed\n", timeout, type, order);
	}
	
	
}
