
public class Truck extends Car{
	
	public Truck() {
		
	}
	
	public void m1() {
		System.out.println("Truck 1");
	}
	
	public String toString() {
		return super.toString() + super.toString();
	}
	
	public static void main(String[] args) {
		Truck mytruck = new Truck();
		Truck truck  = (Truck) new Car();
		System.out.println(mytruck);
		mytruck.m1();
		mytruck.m2();
	}

}
