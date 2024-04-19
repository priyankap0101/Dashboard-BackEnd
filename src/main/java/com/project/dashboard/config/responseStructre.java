package com.project.dashboard.config;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class responseStructre<T> {

	private int statusCode;
	private String message;
	private Object data;
}