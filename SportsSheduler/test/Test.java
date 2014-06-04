
public class Test {
	
	public static void main(String[] args) {
		Test ref1 = new Test();
		Test ref2 = ref1;
		Test ref3 = new Test();
		System.out.println(ref1);
		System.out.println(ref2);
		System.out.println(ref3);
		ref1 = null;
		System.out.println(ref1);
		System.out.println(ref2);
		System.out.println(ref3);
	}
}
