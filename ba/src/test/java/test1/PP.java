package test1;

import java.io.IOException;
import java.sql.SQLException;

class cc {
	public void method1() throws IOException{
		
	}
}

public class PP extends cc {
	public void method1() throws IOException{
		try {
			throw new SQLException();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		String op;
		cc p = new PP();
		p.method1();
	}
}
