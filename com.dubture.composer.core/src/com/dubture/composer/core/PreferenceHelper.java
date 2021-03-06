package com.dubture.composer.core;

import java.util.StringTokenizer;

public class PreferenceHelper {

	private static final String DELIMITER = ";";

	public static String serialize(String[] elements) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < elements.length; i++) {
			buffer.append(elements[i]);
			buffer.append(DELIMITER);
		}
		return buffer.toString();
	}

	public static String[] deserialize(String value) {
		StringTokenizer tokenizer = new StringTokenizer(value, DELIMITER);
		int tokenCount = tokenizer.countTokens();
		String[] elements = new String[tokenCount];
		for (int i = 0; i < tokenCount; i++) {
			elements[i] = tokenizer.nextToken();
		}

		return elements;
	}
}
