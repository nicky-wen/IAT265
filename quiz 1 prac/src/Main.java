public class Main {
	public static void main(String[] args) {
		System.out.println("chris is a dog");
		Dog chris = new Dog("chris", 0);
		chris.printDetails();

		Dog nicky = new Dog("master", 100);
		nicky.printDetails();
		Dog kimi = new Dog("dummy", 8);
		kimi.printDetails();

	}

}