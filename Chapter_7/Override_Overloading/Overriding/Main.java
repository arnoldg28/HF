public class Main{
	public static final void main(String args[]){
		Appliance app = new Toaster();
		app.turnOn(new Parent());
		app.turnOn(new Child());
	}
}