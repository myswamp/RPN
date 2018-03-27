package com.xxx.strategy;

import java.math.BigDecimal;

public interface UniaryOperation extends Operation {
	public BigDecimal calculate(BigDecimal operatant);
}
