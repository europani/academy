package ch04.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch02.sensor.Monitor;
import ch02.sensor.Sensor;

@Configuration
public class ConfigSensor {
	
	@Bean
	public Sensor sensor1() {
		Sensor s = new Sensor();
		Properties properties = new Properties();
		properties.setProperty("threshold", "1500");
		properties.setProperty("retry", "3");
		s.setAdditionalInfo(properties);
		return s;
	}
	
	@Bean
	public Sensor sensor2() {
		Sensor s = new Sensor();
		Properties properties = new Properties();
		properties.setProperty("threshold", "3000");
		properties.setProperty("retry", "5");
		s.setAdditionalInfo(properties);
		
		Set<String> codes = new HashSet<String>();
		codes.add("200");
		codes.add("300");
		s.setAgentCodes(codes);
		return s;
	}
	
	@Bean
	public Monitor monitor() {
		Monitor m = new Monitor();
		Map<String, Sensor> sensorMap = new HashMap<String, Sensor>();
		sensorMap.put("frontdoor", sensor1());
		sensorMap.put("backDoor", sensor2());
		m.setSensorMap(sensorMap);
		
		Map<String, Integer> config = new HashMap<String, Integer>();
		config.put("interval", 1000);
		config.put("period", 2000);
		m.setConfig(config);
		
		return m;
	}
	
}
