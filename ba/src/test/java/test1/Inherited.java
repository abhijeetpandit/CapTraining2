package test1;

import java.io.FileNotFoundException;
import java.sql.SQLException;

class Parent {
	public void method1() throws FileNotFoundException {
		
	}
}


public class Inherited extends Parent {

	@Override
	public void method1() throws FileNotFoundException {
		SQLException s = new SQLException();
		FileNotFoundException e = new FileNotFoundException();
		e.initCause(s);
		throw e;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Parent p = new Inherited();
		p.method1();
	}

}
