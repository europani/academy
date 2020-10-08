package ch06;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WorkScheduler implements ApplicationContextAware {
	private WorkRunner workRunner;
	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext ApplicationContext) throws BeansException {
		this.ctx = ApplicationContext;
	}
	
	public void makeAndRunWork() {
		for (long order = 0; order <= 10; order++) {
			Work work = ctx.getBean("workProto", Work.class);
			work.setOrder(order);
			workRunner.execute(work);
		}
	}
	
	public void setWorkRunner(WorkRunner workRunner) {
		this.workRunner = workRunner;
	}
	
}
