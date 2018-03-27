package com.xxx;


import java.math.BigDecimal;

public class InputValidator {
	
	public static boolean isOperator(String string) {
		if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")
				|| string.equals("sqrt") || string.equals("undo") || string.equals("clear")) {
			return true;
		}
		return false;
	}

	public static boolean isValidComponent(String string) {
		if (isOperator(string)) {
			return true;
		} else {
			try {
				new BigDecimal(string);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
}
