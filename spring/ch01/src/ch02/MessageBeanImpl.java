package ch02;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
	
	private Outputter outputter;
	
	public MessageBeanImpl(String name) {
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}


	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	@Override
	public void sayHello() {
		try {
			outputter.output(greeting + " " + name + "!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(greeting + " " + name + "!");
	}
	
	

}
