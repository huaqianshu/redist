package com.mqtest.com.redistest.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:day.properties", ignoreResourceNotFound = true)
@ConfigurationProperties("day")
public class Daysconf {
	private static Map<String, String> maps;

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
}
