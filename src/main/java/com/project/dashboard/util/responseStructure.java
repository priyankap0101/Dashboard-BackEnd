package com.project.dashboard.util;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class responseStructure<T> {

	private int statusCode;
	private String message;
	private Object data;
}



