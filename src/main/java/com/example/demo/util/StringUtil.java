package com.example.demo.util;

import org.springframework.util.DigestUtils;

public class StringUtil {

	public static String toMd5(String value) {
		return DigestUtils.md5DigestAsHex(value.getBytes());
	}

}
