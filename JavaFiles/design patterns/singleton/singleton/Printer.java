package singleton;

public class Printer {
	private static Printer instance;
	private int pg;
	private Printer() {}
	public static synchronized Printer getInstance() {
		if (instance==null) {
			instance=new Printer();
		}
		return instance;
		
	}
	public void print() {
		System.out.println("printed text");
	}

}
