import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;



enum Zodiac {

	//declare constant enums
	Rat("RAT","1996"),
	Ox("OX", "1997"),
	Tiger("TIGER", "1998"),
	Rabbit("RABBIT", "1999"),
	Dragon("DRAGON", "2000"),
	Snake("SNAKE", "2001"),
	Horse("HORSE", "2002"),
	Goat("GOAT", "2003"),
	Monkey("MONKEY", "2004"),
	Rooster("ROOSTER", "2005"),
	Dog("DOG", "2006"),
	Pig("PIG", "2007");
	
	//instance variables
	private final String zodiacName;
	private final String zodiacYear;

	//enum constructor
	private Zodiac(String zodiacName, String zodiacYear) {
		this.zodiacName = zodiacName;
		this.zodiacYear = zodiacYear;
	}

	//accessor for field zodiac name
	public String getZodiacName() {
		return zodiacName;
	}

	//accessor for field zodiac year
	public String getZodiacYear() {
		return zodiacYear;
	}
}



class Set {
	
	//declare an array list
	private ArrayList<Zodiac> s;

	//default constructor
	public Set() {
		this.s = new ArrayList<Zodiac>();
	}

	
	//deep copy constructor
	public Set(Set otherSet) {
		this.s = new ArrayList<Zodiac>();

		for (int i = 0; i < otherSet.s.size(); i++) {
			s.add(otherSet.s.get(i));
		}
	}

	//check if set is empty
	public boolean isEmpty() {
		
		if (this.s.isEmpty()) {
			return true;
		}

		return false;
	}

	//return the number of elements in a set
	public int cardinality() {
		return this.s.size();
	}

	//checking element belong to which set
	public boolean belongsTo(Zodiac element) {
		return this.s.contains(element);
	}

	//adding element to set
	public void addElement(Zodiac element) {
		if (belongsTo(element) == false) {
			this.s.add(element);
		}
	}

	//checking subset
	public boolean subset(Set otherSet) {
		return otherSet.s.containsAll(s);
	}

	//adding two sets without duplicate
	public void union(Set otherSet) {
		for (Zodiac zodiac : otherSet.s) {
			if (!this.s.contains(zodiac)) {
				this.s.add(zodiac);
			}
		}
	}

	//find the intersect
	public void intersection(Set otherSet) {
		this.s.retainAll(otherSet.s);
	}

	//finding the difference between two set
	public void difference(Set otherSet) {
		this.s.removeAll(otherSet.s);
	}

	//display what are the missing zodiac in the set
	public Set complement() {
		Set com = new Set();

		for (Zodiac zo : Zodiac.values()) {
			if (!this.s.contains(zo)) {
				com.addElement(zo);
			}
		}
		return com;
	}

	//check if two sets are equal
	public boolean equality(Set otherSet) {
		return subset(otherSet) && s.containsAll(otherSet.s);
	}

	//get enum format
	public String getEnumFormat() {
		StringBuffer appendingStr = new StringBuffer(" = {");

		for (Zodiac zodiac : this.s) {
			if (s.isEmpty()) {
				return " = { }";
			} else {
				appendingStr.append(zodiac);
				appendingStr.append(", ");
			}
		}

		appendingStr.setLength(appendingStr.length() - 2);
		appendingStr.append("}");
		return appendingStr.toString();
	}

	// get year format
	public String getYearFormat() {
		StringBuffer appendingStr = new StringBuffer("= {");

		for (Zodiac zodiac : this.s) {
			if (s.isEmpty()) {
				return " = { }";
			} else {
				appendingStr.append(zodiac.getZodiacYear());
				appendingStr.append(", ");
			}
		}

		appendingStr.setLength(appendingStr.length() - 2);
		appendingStr.append("}");
		return appendingStr.toString();
	}

	//return zodiac names
	public String toString() {
		StringBuffer appendingStr = new StringBuffer(" = {");

		for (Zodiac zodiac : this.s) {
			if (s.isEmpty()) {
				return " = { }";
			} else {
				appendingStr.append(zodiac.getZodiacName());
				appendingStr.append(", ");
			}
		}

		if (s.isEmpty() == false) {
			appendingStr.setLength(appendingStr.length() - 2);
		} else {
			appendingStr.setLength(appendingStr.length() - 1);
		}

		appendingStr.append("}");
		return appendingStr.toString();
	}
}




public class A1 {
	
	private static Scanner input = new Scanner(System.in);
	
	//displaying zodiac info
	private static void displayZodiacInfo() {
		System.out.println("Universal set info\n");
		System.out.printf("%-14s%-14s%-14s%n", "Zodiac Sign", "Known as", "For example");

		for (Zodiac zodiac : Zodiac.values()) {
			System.out.printf("%-14s%-14s%-14s%n", zodiac, zodiac.getZodiacName(), "Year " + zodiac.getZodiacYear());
		}
		System.out.println();
	}

	//get an element
	private static Zodiac getAnElement() {
		ArrayList<Zodiac> getRandomElement = new ArrayList<>();

		for (Zodiac zodiac : Zodiac.values()) {
			getRandomElement.add(zodiac);
		}

		Collections.shuffle(getRandomElement);

		return getRandomElement.get(0);
	}
	
	//get a random set
	private static Set getASet() {
		Random random = new Random();
		int num = random.nextInt(12);
		Set set = new Set();

		for (int i = 0; i < num; i++) {
			Zodiac zodiac = getAnElement();

			if (set.isEmpty()) {
				set.addElement(zodiac);
			} else if (!set.belongsTo(zodiac)) {
				set.addElement(zodiac);
			}
		}

		return set;
	}

	
	//display main menu
	private static void displayMenu() {
		System.out.println("Welcome to SIM Set Theory lesson");
		System.out.println();
		System.out.println("0: Properties of set");
		System.out.println("1: Union example");
		System.out.println("2: Intersection example");
		System.out.println("3: Subset example");
		System.out.println("4: Difference example");
		System.out.println("5: Complement example");
		System.out.println("6: Sets equality example");
		System.out.println("7: Distributive Law 1");
		System.out.println("8: Distributive Law 2");
		System.out.println("9: Quit");
		System.out.println();
	}

	//display union example
	private static void unionExample() {
		Set setA = getASet();
		Set setB = getASet();

		System.out.println("Given Sets");
		System.out.println("\tA" + setA);
		System.out.println("\tB" + setB);
		setA.union(setB);

		System.out.println("\tUnion of A and B" + setA);
		System.out.println("---------------------------------------------------------");
	}

	//display intersect example
	private static void intersectionExample() {
		Set setA = getASet();
		Set setB = getASet();

		System.out.println("Given Sets");
		System.out.println("\tA" + setA);
		System.out.println("\tB" + setB);

		setA.intersection(setB);
		System.out.println("\tIntersection of A and B" + setA);
		System.out.println("---------------------------------------------------------");
	}

	//display subset example
	private static void subsetExample() {
		Set setA = getASet();
		Set setB = getASet();

		System.out.println("Given Sets");
		System.out.println("\tA" + setA);
		System.out.println("\tB" + setB);
		System.out.println();

		boolean A = setA.subset(setB);
		boolean B = setB.subset(setA);

		System.out.println("Conclusion");
		System.out.println("\tA subset of B: " + A);
		System.out.println("\tB subset of A: " + B);

		System.out.println("---------------------------------------------------------");
	}

	//display difference
	private static void differenceExample() {
		Set setA = getASet();
		Set setB = getASet();

		System.out.println("Given Sets");
		System.out.println("\tA" + setA);
		System.out.println("\tB" + setB);

		setA.difference(setB);

		System.out.println("\tA - B" + setA);

	}

	//display complement example
	private static void complementExample() {
		Set setA = getASet();

		System.out.println("Given Sets");
		System.out.println("\tA " + setA);
		System.out.println("\tA'" + setA.complement());

		System.out.println("---------------------------------------------------------");
	}

	//display equality example
	private static void equalityExample() {
		Set setA = getASet();
		Set setB = getASet();

		System.out.println("Given Sets");
		System.out.println("\tA" + setA);
		System.out.println("\tB" + setB);

		boolean A = setA.equality(setB);
		boolean B = setB.equality(setA);
		boolean finalCheck = false;

		if ((A == true) && (B == true)) {
			finalCheck = true;
		} else {
			finalCheck = false;
		}
		
		System.out.println();
		System.out.println("Analysis");
		boolean AsubB = setA.subset(setB);
		boolean BsubA = setB.subset(setA);
		System.out.println("\tA subset of B: " + AsubB);
		System.out.println("\tB subset of A: " + BsubA);
		System.out.println("");

		System.out.println("Conclusion");
		System.out.println("\tA equals to B: " + finalCheck);

		System.out.println("---------------------------------------------------------");
	}

	//distributive law example
	private static void distributiveLaw() {
		Set setA_LHS = getASet();
		Set setA_RHS = new Set(setA_LHS);
		Set setA_RHS_1 = new Set(setA_LHS);

		Set setB_LHS = getASet();
		Set setB_RHS = new Set(setB_LHS);

		Set setC_LHS = getASet();
		Set setC_RHS = new Set(setC_LHS);

		System.out.println("We wish to prove: A U (B I C) = (A U B) I (A U C)");
		System.out.println();

		System.out.println("Given Sets");
		System.out.println("\tA" + setA_LHS);
		System.out.println("\tB" + setB_LHS);
		System.out.println("\tC" + setC_LHS);
		System.out.println();

		setB_LHS.intersection(setC_LHS);
		setA_LHS.union(setB_LHS);
		setA_RHS.union(setB_RHS);
		setA_RHS_1.union(setC_RHS);
		setA_RHS.intersection(setA_RHS_1);

		boolean conclusion = setA_LHS.equality(setA_RHS);

		System.out.println("LHS analysis");
		System.out.println("\tLHS" + setA_LHS);
		System.out.println();
		System.out.println("RHS analysis");
		System.out.println("\tRHS" + setA_RHS);
		System.out.println();
		System.out.println("Conclusion");
		System.out.println("\tLHS = RHS is " + conclusion);

		System.out.println("---------------------------------------------------------");
	}
	
	//distributive law 2 example
	private static void distributiveLaw2() {

		Set setA_LHS = getASet();
		Set setA_RHS = new Set(setA_LHS);
		Set setA_RHS_1 = new Set(setA_LHS);
		Set setB_LHS = getASet();
		Set setB_RHS = new Set(setB_LHS);
		Set setC_LHS = getASet();
		Set setC_RHS = new Set(setC_LHS);
		System.out.println("We wish to prove: A I (B U C) = (A I B) U (A I C)");
		System.out.println();


		setA_LHS.intersection(setB_LHS);
		setB_LHS.union(setC_LHS);
		setA_RHS.union(setA_RHS_1);
		setA_RHS_1.intersection(setC_RHS);
		setA_RHS.intersection(setB_RHS);
		
		boolean conclusion = setA_LHS.equality(setA_RHS);

		System.out.println("LHS analysis");
		System.out.println("\tLHS" + setA_LHS);
		System.out.println();
		System.out.println("RHS analysis");
		System.out.println("\tRHS" + setA_RHS);
		System.out.println();
		System.out.println("Conclusion");
		System.out.println("\tLHS = RHS is " + conclusion);

		System.out.println("---------------------------------------------------------");
	}

	//displaying sub menu
	private static void displaySubMenu() {
		System.out.println("Some basic operations in set");
		System.out.println("\t1. Add an element");
		System.out.println("\t2. Check an element");
		System.out.println("\t3. Cardinality");
		System.out.println("\t4. Enum format");
		System.out.println("\t5. Year format");
		System.out.println("\t9. Quit\n");
	}


	//get example
	private static void anExample() {
		
		Set setA = getASet();

		System.out.println("Here is an example of set");
		System.out.print("\tA");
		System.out.println(setA);
		System.out.println("\tAll elements in set are distinct and random order\n");
		displaySubMenu();

		System.out.printf("Enter your option: ");
		int option = input.nextInt();

		while (option != 9) {
			switch (option) {
			case 1:
				System.out.print("Enter a Sign: ");
				Zodiac zodiac = Zodiac.valueOf(input.next());

				setA.addElement(zodiac);

				System.out.print("A");
				System.out.println(setA);
				System.out.println("---------------------------");
				displaySubMenu();
				break;

			case 2:

				System.out.print("Enter a Element: ");
				Zodiac element = Zodiac.valueOf(input.next());
				setA.belongsTo(element);

				if (setA.belongsTo(element) == true) {
					System.out.printf("Element %s is in the set%n", element);
				} else {
					System.out.printf("Element %s is not in the set%n", element);
				}
				System.out.println("---------------------------");
				displaySubMenu();
				break;

			case 3:
				System.out.printf("No of elements in set is %d%n", setA.cardinality());
				System.out.println("---------------------------");
				displaySubMenu();
				break;

			case 4:
				System.out.printf("Notation in enum format%n");
				System.out.println("\tA " + setA.getEnumFormat());
				System.out.println("---------------------------");
				displaySubMenu();
				break;

			case 5:
				System.out.printf("Notation in year format%n");
				System.out.println("\tA " + setA.getYearFormat());
				System.out.println("---------------------------");
				displaySubMenu();
				break;

			case 9:
				input.close();
				break;
			}

			System.out.printf("Enter your option: ");
			option = input.nextInt();
			System.out.println();
		}

	}


	
	public static void main(String[] args) {

		displayZodiacInfo();
		displayMenu();

		System.out.printf("Your option: ");
		int option = input.nextInt();

		System.out.println();

		while (option != 9) {
			switch (option) {
			case 0:
				anExample();
				break;

			case 1:
				unionExample();
				break;

			case 2:
				intersectionExample();
				break;

			case 3:
				subsetExample();
				break;

			case 4:
				differenceExample();
				break;

			case 5:
				complementExample();
				break;

			case 6:
				equalityExample();
				break;

			case 7:
				distributiveLaw();
				break;
			
			case 8:
				distributiveLaw2();
				break;

			case 9:
				input.close();
				break;
			}
			System.out.println();
			displayMenu();

			System.out.printf("Your option: ");
			option = input.nextInt();
			System.out.println();
		}

	}
}
