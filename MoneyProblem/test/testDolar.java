import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Followed book to Chapter 15
public class testDolar {
	private Money fivedolar;
	private Money sevendolar;
	private Money fivefranc;

	@Before
	public void setUp() {
		fivedolar = Money.dollar(5);
		sevendolar = Money.dollar(7);
		fivefranc = Money.franc(5);
	}

	@Test
	public void testMultiply() throws Exception {
		fivedolar.times(2);
		assertEquals(5, fivedolar.ammount(), 0.00001);
	}

	@Test
	public void testMultiplication() {
		assertEquals(fivedolar.times(2), Money.dollar(10));
		assertEquals(fivedolar.times(3), Money.dollar(15));

	}

	@Test
	public void testEquallity() {
		Money newfivedolar = Money.dollar(5);
		assertTrue(fivedolar.equals(newfivedolar));
		assertFalse(fivedolar.equals(sevendolar));
	}

	@Test
	public void testFrancMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.franc(10), fivefranc.times(2));
		assertEquals(Money.franc(15), fivefranc.times(3));
		assertNotEquals(Money.franc(10), five.times(2));
	}

	@Test
	public void testFrancAndDolars() {
		assertNotEquals(fivedolar, fivefranc);
	}

	@Test
	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}

	@Test
	public void testSimpleAdd() {
		Expression allmoney = fivedolar.add(fivedolar);

		assertEquals(10, allmoney.reduce("USD").ammount, 0.001);
	}

	@Test
	public void testNotSimpleAdd() {
		Money five = Money.dollar(5);
		Expression sum = (Expression) five.add(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}

	@Test
	public void testDollarPlusFranc() {
		Expression allmoney = fivedolar.add(fivefranc);
		double total = allmoney.reduce("CHF").ammount;
		// assertEquals(7.5, total,0.001);
		// TODO
	}

	@Test
	public void testPlusReturnsSum() {
		Money five = Money.dollar(5);
		Expression result = five.add(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}

	@Test
	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7), result);
	}

	@Test
	public void testReduceMoney() {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), result);
	}

}
