
public class Sum implements Expression {
	Money augend;
	Money addend;
	
	Sum(Money augend, Money addend) {
		this.augend= augend;
		this.addend= addend;
	}

	public Money reduce(String currency) {
		double amount= augend.ammount + addend.ammount;
		return new Money(amount, currency);
	}

}
