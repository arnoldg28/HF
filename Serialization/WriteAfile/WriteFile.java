import java.io.*;

class WriteFile{
	public static final void main(String[] args){
		try{
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("Hello foo");
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}