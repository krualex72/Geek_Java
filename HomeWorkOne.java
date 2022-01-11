public class HomeWorkOne {
    public static void main(String[] args) {
		System.out.println("### Section 2 ###");
		printThreeWords();
		System.out.println("\n### Section 3 ###");
		checkSumSign();
		System.out.println("\n### Section 4 ###");
		printColor();
		System.out.println("\n### Section 5 ###");
		compareNumbers(); 
	}

	public static void printThreeWords() {
		System.out.println("Orange");
		System.out.println("Banana");
		System.out.println("Apple");
	}

	public static void checkSumSign() {
		int a = 5;
		int b = -12;
		if ((a+b) >= 0) {
			System.out.println("The Summ is Positive");
			} else {
				System.out.println("The Summ is Negative");
			}
	}

	public static void printColor() {
		int value = 700;
		if (value <= 0) {
			System.out.println("Red");
		} else {
			if (value > 0 && value <= 100 ) {
				System.out.println("Yellow");
				} else {
					System.out.println("Green");
				}
		}
	}

	public static void compareNumbers() {
		int a = -15;
		int b = -5;
		if (a >= b) {
			System.out.println("a >= b");
			} else {
				System.out.println("a < b");
				}
	}
}