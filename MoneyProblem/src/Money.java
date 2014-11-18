
public class Money  implements Expression {
	protected double ammount = 0;
	protected String currency;

	public Money(double amount, String currency) {
		this.ammount = amount;
		this.currency = currency;
	}

	public boolean equals(Object object) {
		Money money = (Money) object;
		return money.ammount == this.ammount
				&& currency().equals(money.currency());

	}

	public double ammount() {
		return this.ammount;
	}

	public Money times(double multipleyer) {
		return new Money(this.ammount * multipleyer, this.currency);
	}

	public static Money dollar(double amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(double ammount) {
		return new Money(ammount, "CHF");
	}

	public String currency() {
		return currency;
	}

	public String toString() {
		return ammount + " " + currency;
	}

	public Expression add(Money addend) {
		return new Sum(this, addend);
	}
	public Money reduce(String to) {
		return this;
		}

}
