package com.xxx.strategy;

import java.math.BigDecimal;

public interface BinaryOperation extends Operation{
	
	public BigDecimal calculate(BigDecimal operant1, BigDecimal operantf2);
}
