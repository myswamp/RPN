package com.xxx;

import org.junit.Assert;
import org.junit.Test;

public class RPNCalculatorTest {
	
	RPNCalculator calculator = new RPNCalculator();
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput() {
		calculator.process("xxx");
	}
	
	@Test
	public void testClear(){
		Assert.assertEquals(calculator.process("2 sqrt clear"), "stack:");
	}
	
	@Test
	public void testAdd() {
		Assert.assertEquals(calculator.process("5 2 +"), "stack: 7");
	}
	
	@Test
	public void testSubtract() {
		Assert.assertEquals(calculator.process("5 2 -"), "stack: 3");
	}
	
	@Test
	public void testMultiply() {
		Assert.assertEquals(calculator.process("5 2 *"), "stack: 10");
	}
	
	@Test
	public void testDivide() {
		Assert.assertEquals(calculator.process("5 2 /"), "stack: 2.5");
		Assert.assertEquals(calculator.process("clear 6 2 /"), "stack: 3");
		Assert.assertEquals(calculator.process("clear 2 6 /"), "stack: 0.3333333333");
	}
	
	@Test
	public void testSqrt() {
		Assert.assertEquals(calculator.process("2 sqrt"), "stack: 1.4142135623");
	}
	
	@Test
	public void testCombo() {
		Assert.assertEquals(calculator.process("7 12 2 / * 4 / 5 + 2 -"), "stack: 13.5");
	}
	
	@Test
	public void testUndo() {
		Assert.assertEquals(calculator.process("10 5 * undo"), "stack: 10 5");
		Assert.assertEquals(calculator.process("clear 10 5 5 undo undo"), "stack: 10");
	}
	
	@Test
	public void testInsucient() {
		Assert.assertEquals(	calculator.process("-"), "stack:");
		Assert.assertEquals(calculator.process("1 2 - +"), "stack: -1");
	}
}
