package com.xxx;

import com.xxx.strategy.Addition;
import com.xxx.strategy.BinaryOperation;
import com.xxx.strategy.Division;
import com.xxx.strategy.Multiplication;
import com.xxx.strategy.SquareRoot;
import com.xxx.strategy.Subtraction;
import com.xxx.strategy.UniaryOperation;

public abstract class AbstractCalculator {
	protected static final String ADD = "+";

	protected static final String SUBTRACT = "-";

	protected static final String MULTIPLY = "*";

	protected static final String DIVIDE = "/";

	protected static final String SQRT = "sqrt";
	
	protected static final String CLEAR = "clear";

	protected static final String UNDO = "undo";

	protected String inputExpression;

	public String process(String inputExpression) {
		this.inputExpression = inputExpression;
		calculate();
		return display();
	}

	protected abstract void calculate();

	protected abstract String display();

	protected BinaryOperation getBinaryOperation(String operator) {
		BinaryOperation operation = null;
		switch (operator) {
		case ADD:
			operation = new Addition();
			break;
		case SUBTRACT:
			operation = new Subtraction();
			break;
		case MULTIPLY:
			operation = new Multiplication();
			break;
		case DIVIDE:
			operation = new Division();
			break;
		default:
			throw new UnsupportedOperationException();
		}
		return operation;
	}

	protected UniaryOperation getUinaryOperation(String operator) {
		UniaryOperation operation = null;
		switch (operator) {
		case SQRT:
			operation = new SquareRoot();
			break;
		default:
			throw new UnsupportedOperationException();
		}
		return operation;
	}

}
