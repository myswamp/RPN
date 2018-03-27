package com.xxx;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.xxx.strategy.BinaryOperation;
import com.xxx.strategy.UniaryOperation;

public class RPNCalculator extends AbstractCalculator {

	private static final int DECIMAL_PLACE_TEN = 10;

	protected LinkedList<BigDecimal> stack = new LinkedList<>();

	protected LinkedList<BigDecimal> undoStack = new LinkedList<>();

	@Override
	protected String display() {
		StringBuilder sb = new StringBuilder("stack:");
		ListIterator<BigDecimal> it = stack.listIterator(stack.size());
		while (it.hasPrevious()) {
			sb.append(" ").append(
					it.previous().setScale(DECIMAL_PLACE_TEN, RoundingMode.DOWN).stripTrailingZeros().toPlainString());
		}
		return sb.toString();
	}

	@Override
	protected void calculate() {
		int index = 1;
		for (String string : this.inputExpression.split(" ")) {
			if (!InputValidator.isValidComponent(string))
				throw new IllegalArgumentException();

			if (!InputValidator.isOperator(string)) {
				pushToStack(string);
			} else {
				try {
					executeCommand(string);
				} catch (NoSuchElementException e) {
					if (!undoStack.isEmpty())
						stack.push(undoStack.pop());
					System.out.println(
							"operator " + string + " (position: " + (2 * index - 1) + "): insucient parameters");
					break;
				}
			}
			index++;
		}
	}


	private void executeCommand(String command) {
		if (command.equals(ADD) || command.equals(SUBTRACT) || command.equals(MULTIPLY) || command.equals(DIVIDE)) {
			binaryOperation(command);
		} else if (command.equals(SQRT)) {
			uniaryOperation(command);
		} else if (command.equals(CLEAR)) {
			clear();
		} else if (command.equals(UNDO)) {
			undo();
		} else {
			throw new UnsupportedOperationException();
		}
	}

	private void clear() {
		stack.clear();
		undoStack.clear();
	}

	private void undo() {
		stack.pop();
		for (int i = 0; i < 2; i++)
			if (!undoStack.isEmpty())
				stack.push(undoStack.pop());

	}

	private void pushToStack(String operant) {
		stack.push(new BigDecimal(operant));
	}

	private void binaryOperation(String operator) {
		BinaryOperation biOperation = getBinaryOperation(operator);
		BigDecimal d1 = stack.pop();
		undoStack.push(d1);
		BigDecimal d2 = stack.pop();
		undoStack.push(d2);
		stack.push(biOperation.calculate(d1, d2));
	}

	private void uniaryOperation(String operator) {
		UniaryOperation uniOperation = getUinaryOperation(operator);
		BigDecimal d1 = stack.pop();
		undoStack.push(d1);
		stack.push(uniOperation.calculate(d1));
	}
}
