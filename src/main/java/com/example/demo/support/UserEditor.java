package com.example.demo.support;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringUtils;

public class UserEditor extends PropertyEditorSupport {
	
	@Override
	public String getAsText() {
		Object value = super.getValue();
		return value == null ? StringUtils.EMPTY : value.toString();
	}
	
	@Override
	public void setAsText(String text) {
		String value = StringUtils.strip(StringUtils.defaultString(text));
		super.setValue(value);
	}
	
}
