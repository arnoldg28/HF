public class Toaster extends Appliance{

	/* Same argument (Passed)
	   Compatible return type (Passed)
	   Method cant be less accessible (Failed)
	   
	   Result: Compile error
	   attempting to assign weaker access privileges; was public
	
	Parent turnOn(Parent p){
		System.out.println("Toaster: Parent turnOn(Parent p)");
		return null; 
	}
	*/
	
	/* Same argument (Failed)
	   Compatible return type (Passed)
	   Method cant be less accessible (Passed)
	  
	   Result: Compiled, BUT this is and Overloaded method!
	*/
	public Parent turnOn(Child c){
		System.out.println("Toaster: Parent turnOn(Child c)");
		return null; 
	}
	
	
	/* Same argument (Passed)
	   Compatible return type (Passed)
	   Method cant be less accessible (Passed)
	  
	   Result: Valid Overriding
	*/
	public Parent turnOn(Parent p){
		System.out.println("Toaster: public Parent turnOn(Parent p)");
		return null;
	}
	
}