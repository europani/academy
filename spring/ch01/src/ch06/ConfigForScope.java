package ch06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ch06.Work.WorkType;

@Configuration
public class ConfigForScope {

	@Bean
	@Scope("prototype")
	public Work workProto() {
		Work work = new Work();
		work.setTimeout(2000L);
		work.setType(WorkType.SINGLE);
		return work;
	}
	
	@Bean
	public WorkRunner workRunner() {
		return new WorkRunner();
	}
	@Bean
	public WorkScheduler workScheduler() {
		WorkScheduler workScheduler = new WorkScheduler();
		workScheduler.setWorkRunner(workRunner());
		return workScheduler;
	}
}
