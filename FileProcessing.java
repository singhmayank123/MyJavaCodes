
import java.io.PrintWriter; 
import java.io.FileWriter;

class FNFException extends Exception{

	String msg;

	public FNFException(String msg){
		this.msg = msg;
	}

	public String getMessage(){
		return msg;
	}
} 

public class FileProcessing{

	public static void main(String[] args){

		try{

			FileWriter fw = new FileWriter("MyFile.cpp", true);
			PrintWriter out = new PrintWriter(fw);	
			out.println("#include<iostream>");
			out.println("using namespace std; ");
			out.println("int main(){ }");

			out.close();

			if(true){
				throw new FNFException("file not found");
			}

		}

		catch(FNFException f){

			System.out.println(f.getMessage());
		}

		catch(Exception e){

		}

		
	



	}
}