/* good Work
 * score 10 + extra credit 3.5; Total score = 10
 */
import java.util.ArrayList;

public class Assignment2 {

	// No.1
	// score 2
	public static double employeeSalary(double hours) {
		double sum = 0;
		if (hours >= 0 && hours <= 36) {
			sum = sum + hours * 15.0;
		} else if (hours > 36 && hours <= 41) {
			sum = sum + 36 * 15.0 + (hours - 36) * 15 * 1.5;
		} else if (hours > 41 && hours <= 48) {
			sum = sum + 36 * 15.0 + 5 * 15 * 1.5 + (hours - 41) * 15 * 2;
		} else if (hours > 48) {
			sum = sum + 36 * 15.0 + 5 * 15 * 1.5 + 7 * 15 * 2;
		}

		return sum;
	}

	// No.2
	// score 2
	public static int addDigits(int input) {
		int sum = 0;
		int remainder;
		if (input / 10 == 0) {
			return input;
		}
		while (input / 10 != 0) {
			while (input / 10 != 0) {
				remainder = input % 10;
				sum = sum + remainder;
				input = input / 10;
			}
			input = input + sum;
			sum = 0;

		}
		return input;
	}

	// No.3
	//score 2
	public static void printPerfectNumbers(int n) {
		int count = 0;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < i; j++) {
				// "i" functions as the dividend, "j" functions as the divisor.
				if (i % j == 0) {
					count = count + j;
				}
			}
			if (count == i) {
				System.out.println(i);
			}
			count = 0;
		}

	}

	// No.4
	// score 2 + extra credit 0.5
	public class Pizza {
		String pizzaType;
		double unitPrize;
		double loyaltyPoints;

		public Pizza(String pizzaType, double unitPrize, double loyaltyPoints) {
			this.pizzaType = pizzaType;
			this.unitPrize = unitPrize;
			this.loyaltyPoints = loyaltyPoints;
		}

		public Pizza(String pizzaType, double unitPrize) {
			this.pizzaType = pizzaType;
			this.unitPrize = unitPrize;
		}

		public Pizza(String pizzaType) {
			this.pizzaType = pizzaType;
		}

		public Pizza() {
		}

	}

	// No.5
	// score 2 + extra credit 1
	class Customer {
		String name;
		ArrayList<Pizza> orderedPizza;

		public double totalPrice() {
			double total = 0;
			if (orderedPizza != null) {
				for (int i = 0; i < orderedPizza.size(); i++) {
					total = total + orderedPizza.get(i).unitPrize;
				}
			}
			return total;
		}

		public void addPizza(Pizza pizza) {
			this.orderedPizza.add(pizza);
		}

		public Customer(String name, ArrayList<Pizza> orderedPizza) {
			this.name = name;
			this.orderedPizza = orderedPizza;
		}

		public void main(String[] args) {
			ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
			Customer customer = new Customer("c1", pizzaList);
			Pizza pizzaA = new Pizza("typeA", 3.0, 10);
			Pizza pizzaB = new Pizza("typeB", 5.2, 20);
			customer.addPizza(pizzaA);
			customer.addPizza(pizzaA);
			customer.addPizza(pizzaB);
			System.out.println(customer.totalPrice());
		}
		// In this function, I do not sum the number of each type of pizza the
		// customer ordered,it just add it no matter what type it is. Or we can use Hash Map to
		// record the pizza type and the number of each kind of pizza.
	}

	// No.6
	//extra credit 2
	public static void printIsoscelesTriangle(int n) {
		if (n < 1) {
			System.out.println("Nothing to print!");
		} else {
			System.out.println("*");
			for (int i = 2; i < n + 1; i++) {
				// "i"refers to the line.
				System.out.print("*");
				if (i != n) {
					for (int j = 2; j < i + 1; j++) {
						// "j"refers to jth element in line i .
						if (j < i) {
							System.out.print(" ");
						} else if (j == i) {
							System.out.println("*");
						}
					}

				} else {
					for (int j = 2; j < i + 1; j++) {
						System.out.print("*");
					}
				}
			}
		}
	}

}
