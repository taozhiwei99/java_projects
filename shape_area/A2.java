import java.util.ArrayList;
import java.util.Random;

//enum class for shape colors
enum ShapeColor {
	Blue,
	Yellow,
	Red,
	Green,
	White;
}

//perimeter for 2d and change color for 2d
interface ForTwoD {
	
	public double perimeter();
	
	public void recolor(ShapeColor sc);
}

//area for shapes
interface Shape {
	public double area();
	
}

//volume for 3d and change size for 3d
interface ForThreeD {
	public double volume();
	public void resize(double percentage);
	
}

//abstract class 2D
abstract class TwoD implements ForTwoD, Shape {
	
	//instance variables
	protected ShapeColor sc;
	protected int a, b, c, d;
	
	//default constructor
	public TwoD() {
	}
	
	//constructor for circle
	public TwoD(ShapeColor sc, int a) {
		this.sc = sc;
		this.a =a;
	}
	
	//constructor for rectangle
	public TwoD(ShapeColor sc, int a, int b) {
		this.sc = sc;
		this.a = a;
		this.b = b;
	}
	
	//constructor for triangle
	public TwoD(ShapeColor sc, int a, int b, int c) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//constructor for trapezoid
	public TwoD(ShapeColor sc, int a, int b, int c, int d) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	//copy constructor
	public TwoD(TwoD td) {
		this(td.sc, td.a, td.b, td.c, td.d);
	}
	
	//get methods
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
	
	public int getD() {
		return d;
	}
	
	//return shape color
	public ShapeColor getShapeColor() {
		return sc;
	}
	
	//all the set methods
	public void set(ShapeColor sc, int a) {
		this.sc = sc;
		this.a = a;	
	}
	
	public void set(ShapeColor sc, int a , int b) {
		this.sc = sc;
		this.a = a;
		this.b =b;
	}
	
	public void set(ShapeColor sc, int a, int b, int c) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c =c;
	}
	
	public void set(ShapeColor sc, int a, int b, int c, int d) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	//change color
	public void recolor(ShapeColor sc) {
		
		int i = (int) (Math.random()*5);
		ShapeColor changeColor = ShapeColor.values()[i];
		
		while (getShapeColor() == changeColor) {
			int i2 = (int) (Math.random()*5);
			changeColor = ShapeColor.values()[i2];
		}
		this.sc = changeColor;
	}
	
	//to string
	@Override
    public String toString(){
		if (b == 0 ) {
			return String.format("(2D (%s, %d))", getShapeColor(), getA());
			
		}else if(c == 0 ) {
			return String.format("(2D (%s, %d, %d))", getShapeColor(), getA(), getB());
			
		}else if(d == 0 ) {
			return String.format("(2D (%s, %d, %d, %d))", getShapeColor(), getA(), getB(), getC());
			
		}else {
			return String.format("(2D (%s, %d, %d, %d, %d)", getShapeColor(), getA(), getB(), getC(), getD());	
		}
	}  
}

class Circle extends TwoD {
	
	//default constructor
	public Circle() {
		super();
	}
	
	//constructor
	public Circle(ShapeColor sc, int radius) {
		super(sc, radius);
	}
	
	//copy constructor
	public Circle(Circle c) {
		this(c.sc, c.a);
	}
	
	//calculate area for circle
	@Override
	public double area() {
		return (Math.PI * (getRadius() * getRadius()));
	}
	
	//calculate perimeter for circle
	@Override
	public double perimeter() {
		return (Math.PI * 2 * getRadius());
	}
	
	//calculate radius for circle
	public int getRadius() {
		return super.getA();
	}
	
	//set method
	public void set(ShapeColor sc, int radius) {
		this.sc = sc;
		this.a = radius;
	}
	
	//to string
	@Override
	public String toString() {
		return String.format("Circle %s %n", super.toString());
	}
}

class Rectangle extends TwoD {
	
	//default constructor
	public Rectangle() {
		super();
	}
	
	//constructor
	public Rectangle(ShapeColor sc, int length, int width) {
		super(sc, length, width);
	}
	
	//copy constructor
	public Rectangle(Rectangle r) {
		this(r.sc, r.a, r.b);
	}
	
	//calculate area for rectangle
	@Override
	public double area() {
		return (getLength() * getWidth());
	}
	
	//calculate perimeter for rectangle
	@Override
	public double perimeter() {
		return (2 * (getLength() + getWidth()));
	}
	
	public int getLength() {
		return super.getA();
	}
	
	public int getWidth() {
		return super.getB();
	}
	
	public void set(ShapeColor sc, int length, int width) {
		this.sc = sc;
		this.a = length;
		this.b = width;
	}
	
	//to string
	@Override
	public String toString() {
		return String.format("Rectangle %s %n", super.toString());
	}
}

class Triangle extends TwoD {
	
	//default constructor
	public Triangle() {
		super();
	}
	
	//constructor
	public Triangle(ShapeColor sc, int a, int b, int c) {
		super(sc, a, b, c);
	}
	
	//copy constructor
	public Triangle(Triangle t) {
		this(t.sc, t.a, t.b, t.c); 
	}
	
	//calculate area for triangle
	@Override
	public double area() {
		return ((getA() + getB() + getC()) / 2);
	}
	
	//calculate perimeter for triangle
	@Override
	public double perimeter() {
		return (getA() + getB() + getC());
	}
	
	@Override
	public int getA() {
		return super.getA();
	}
	@Override
	public int getB() {
		return super.getB();
	}
	@Override
	public int getC() {
		return super.getC();
	}
	
	public void set(ShapeColor sc, int a, int b, int c) {
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//to string
	@Override
	public String toString() {
		return String.format("Triangle %s %n", super.toString());
	}
}

class Trapezoid extends TwoD {
	
	//instance variable
	private int h;
	
	//default constructor
	public Trapezoid() {
		super();
	}
	
	//constructor
	public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h) {
		super(sc, a, b ,c ,d);
		this.h = h;
	}
	
	//copy constructor
	public Trapezoid(Trapezoid t) {
		this(t.sc, t.a, t.b, t.c, t.d, t.h); 
	}
	
	//calculate area for trapezoid
	@Override
	public double area() {
		return ((getA() + getB()) / 2 * getHeight() );
	}
	
	//calculate perimeter for trapezoid
	@Override
	public double perimeter() {
		return (getA() + getB() + getC() + getD());
	}
	
	@Override
	public int getA() {
		return super.getA();
	}
	
	@Override
	public int getB() {
		return super.getB();
	}
	
	@Override
	public int getC() {
		return super.getC();
	}
	
	@Override
	public int getD() {
		return super.getD();
	}
	
	public int getHeight() {
		return h;
	}
	
	public void set(ShapeColor sc, int a, int b, int c, int d, int h) {
		this.sc =sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.h = h;
	}
	
	//to string
	@Override
	public String toString() {
		return String.format("Trapezoid %s, %d) %n", super.toString(), getHeight());
	}
}

abstract class ThreeD implements Shape, ForThreeD{
	
	//instance variables
	protected ShapeColor sc;
	protected double a;

	//default constructor
	public ThreeD() {	
	}
	
	//constructor
	public ThreeD(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	//copy constructor
	public ThreeD(ThreeD td) {
		this(td.sc, td.a);
	}
	
	public double getA() {
		return a;
	}
	
	//set color
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	//resize
	public void resize(double percentage) {
		this.a = this.a - ((this.a * percentage) / 100);
	}
	
	//to string
	@Override
	public String toString() {
		return String.format("(3D (%s, %.3f))%n", sc, a);
	}
}

class Cube extends ThreeD {
	
	//default constructor
	public Cube() {
		super();
	}
	
	//constructor
	public Cube(ShapeColor sc, double a) {
		super(sc, a);
	}
	
	//copy constructor
	public Cube(Cube c) {
		this(c.sc, c.a);
	}
	
	//calculate area for cube
	@Override
	public double area() {
		return ( 6 * getA() * getA());
	}
	
	//calculate volume for cube
	@Override
	public double volume() {
		return (getA() * getA() * getA());
	}
	
	@Override
	public double getA() {
		return super.getA();
	}
	
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;	
	}
	
	//to string for cube
	@Override
	public String toString() {
		return String.format("Cube %s", super.toString());
	}
}

class Tetrahedron extends ThreeD {
	
	//default constructor
	public Tetrahedron() {
		super();
	}
	
	//constructor
	public Tetrahedron(ShapeColor sc, double a) {
		super(sc, a);
	}
	
	//copy constructor
	public Tetrahedron(Tetrahedron t) {
		this(t.sc, t.a);
	}
	
	//calculate area for tet
	@Override
	public double area() {
		return Math.sqrt(3) * (getA() * getA());
	}
	
	//calculate volume for tet
	@Override
	public double volume() {
		return (Math.pow(getA(), 3))/(6*Math.sqrt(2));
	}
	
	@Override
	public double getA() {
		return super.getA();
	}
	
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	//to string for tet
	@Override
	public String toString() {
		return String.format("Tetrahedron %s", super.toString());
	}
}


class Sphere extends ThreeD {
	//default constructor
	public Sphere() {
		super();	
	}
	
	//constructor
	public Sphere(ShapeColor sc, double a) {
		super(sc, a);	
	}
	
	//copy constructor
	public Sphere(Sphere s) {
		this(s.sc, s.a);
	}
	
	//calculate area for sphere
	@Override
	public double area() {
		return 4*Math.PI*(getA() * getA());
	}
	
	//calculate volume for sphere
	@Override
	public double volume() {
		return (4/3 * Math.PI* getA() * getA() * getA());
	}
	
	@Override
	public double getA() {
		return super.getA();
	}
	
	public void set(ShapeColor sc, double a) {
		this.sc = sc;
		this.a = a;
	}
	
	//to string for sphere
	@Override
	public String toString() {
		return String.format("Sphere %s", super.toString());
	}
}


public class A2 {
	
	//get a random int
	private static int getInt() {
		Random rand = new Random();
		return rand.nextInt(50);
	}
	
	//get a random double
	private static double getDouble() {
		Random rand = new Random();
		return rand.nextDouble() * 50;
	}
	
	//get a random color
	private static ShapeColor getColor() {
		int i = (int) (Math.random()*5);
		return ShapeColor.values()[i];
	}
	
	//check if its a legit triangle
	private static boolean isTriangle(int a, int b, int c) {
		if ((a+b>c) && (a+c>b) && (b+c>a)) {
			return true;
		}else {
			return false;
		}	
	}
	
	//get a random 2d shape
	private static TwoD getTwoD() {
		Random rand = new Random();
		int i = rand.nextInt(4);
		
		if(i == 0) {
			return new Circle(getColor(), getInt());
			
		}else if(i == 1) {
			return new Rectangle(getColor(), getInt(), getInt());
			
		}else if(i == 2) {
			Triangle tri = new Triangle(getColor(), getInt(), getInt(), getInt());
			if(isTriangle(tri.a, tri.b, tri.c) == true) {
				return tri;
			}
		}else if(i == 3) {
			return new Trapezoid(getColor(), getInt(), getInt(), getInt(), getInt(), getInt());
		}
		
		//return default as circle
		return new Circle(getColor(), getInt());
	}
	
	//get a random 3d shape
	private static ThreeD getThreeD() {
		Random rand = new Random();
		int i = rand.nextInt(3);
		
		if(i == 0) {
			return new Cube(getColor(), getDouble());
			
		}else if(i == 1) {
			return new Tetrahedron(getColor(), getDouble());
			
		}else if(i == 2) {
			return new Sphere(getColor(), getDouble());
		}
		//return default as cube
		return new Cube(getColor(), getDouble());
	}
	
	// process 2d shapes
	private static void process2DShape(Shape ss) {
		
		TwoD twod = (TwoD)ss;

        System.out.printf(twod.toString());
        twod.recolor(twod.sc);
        System.out.printf("Updated color: %s %nArea = %.3f %nI am a %s shape with color changed to %s %n",
        twod.getShapeColor(), ss.area(), ss.getClass().getSimpleName(), twod.getShapeColor());
        System.out.println("---------------------------------------------------------");
	}
	
	
	//process 3d shapes
	private static void process3DShape(Shape ss) {
		
		Random rand = new Random();
        double percentage = rand.nextDouble() * 100;
        ThreeD threeD = (ThreeD)ss;

        System.out.printf(threeD.toString());
        System.out.printf("Surface area = %.3f %nVolume = %.3f %n", threeD.area(), threeD.volume());

        threeD.resize(percentage);

        System.out.printf("Size reduced by %.1f%%: %s (3D (%s, %.3f)) %nUpdated surface area = %.3f %nUpdated volume = %.3f %n",
        		percentage, ss.getClass().getSimpleName(), threeD.sc, threeD.a, ss.area(), threeD.volume());
        System.out.printf("I am a %s shape %n", ss.getClass().getSimpleName());
        System.out.println("---------------------------------------------------------");
	}
	
	//display the list
	//also sort the list to 2d and 3d respectively
	private static void displayList(ArrayList<Shape> alist) {
		
		if (alist.isEmpty()) {
			System.out.println("Arraylist is empty!");
			
		}else {
			for(int i =0; i < alist.size(); i++) {
				Shape shape = alist.get(i);
				System.out.printf("Shape %d: ", i+1);
				if (shape instanceof TwoD) {
					process2DShape(shape);
					
				}else {
					process3DShape(shape);
				}
			}
		}
	
	}

	//main class
	//add random 2d and 3d objects
	public static void main(String[] args) {
		
		ArrayList<Shape> shape = new ArrayList<Shape> ();
		Random rand = new Random();
		int k;
		do {
			k = rand.nextInt(3);
			if (k == 1) {
				shape.add(getTwoD());
				
			}else if (k == 2){
				shape.add(getThreeD());
			}
			k = rand.nextInt(3);

		}
		while (k !=0);
		
		displayList(shape);	
	}
}
