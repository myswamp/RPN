package com.xxx.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Subtraction implements BinaryOperation {

	@Override
	public BigDecimal calculate(BigDecimal operant1, BigDecimal operantf2) {
		return operantf2.subtract(operant1).setScale(DECIMAL_PLACE_FIFTEEN, RoundingMode.DOWN);
	}

}
