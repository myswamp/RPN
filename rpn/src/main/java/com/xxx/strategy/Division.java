package com.xxx.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division implements BinaryOperation {

	@Override
	public BigDecimal calculate(BigDecimal operant1, BigDecimal operant2) {
		return operant2.divide(operant1, DECIMAL_PLACE_FIFTEEN, RoundingMode.DOWN);
	}
}
