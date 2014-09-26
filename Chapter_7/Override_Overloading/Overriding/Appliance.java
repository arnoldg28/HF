//This is just a parent class for testing overriding
public class Appliance{

	public Parent turnOn(Parent p){
		System.out.println("Appliance: public Parent turnOn()");
		return null;
	}
	
	public Parent turnOff(){
		System.out.println("Appliance: public Parent turnOff()");
		return null;
	}
}