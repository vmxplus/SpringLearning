package nust.cs.vmxplus.chapter04.scope;

public class Car {
	private String brand;
	private String color;
	private double price;
	


	public Car(){
		
	}
	
	public Car(String brand, String color, int price){
		this.brand=brand;
		this.color=color;
		this.price=price;
	}
	
	public void introduce(){
		System.out.println("Brand : "+ brand 
				+ " Color : "+ color 
				+ " price : " + price);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
