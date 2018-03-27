package com.xxx.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Multiplication implements BinaryOperation {

	@Override
	public BigDecimal calculate(BigDecimal operant1, BigDecimal operantf2) {
		return operant1.multiply(operantf2).setScale(DECIMAL_PLACE_FIFTEEN, RoundingMode.DOWN);
	}

}
