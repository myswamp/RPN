package com.xxx.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SquareRoot implements UniaryOperation {

	@Override
	public BigDecimal calculate(BigDecimal operatant) {
		return BigDecimal.valueOf(Math.sqrt(operatant.doubleValue())).setScale(DECIMAL_PLACE_FIFTEEN,
				RoundingMode.DOWN);
	}

}
