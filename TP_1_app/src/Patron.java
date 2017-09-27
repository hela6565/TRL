
/**
 * 
 * Starting class for TP-1
 * 
 * Feel free to add, modify, or delete any of the following code: it's just a
 * possible starting implementation
 *
 * @author eric
 *
 */

import java.util.ArrayList;

public class Patron {
	private String name;
	private String patronID;
	private ArrayList<Copy> copiesOut;

	public Patron(String id, String name) {
		this.patronID = id;
		this.name = name;
		this.copiesOut = new ArrayList<Copy>();
	}

	public boolean checkCopyOut(Copy c) {
		c.setOutTo(this);
		this.copiesOut.add(c);
		return true;
	}

	public boolean checkCopyIn(Copy c) {
		this.copiesOut.remove(c);
		c.setOutTo(null);
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Patron))
			return false;
		
		Patron p = (Patron) o;
		
		if (p.patronID.equals(this.patronID)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getPatronID() {
		return this.patronID;
	}

	public String toString() {
		String copyOrCopies = this.copiesOut.size() == 1 ? " copy" : " copies"; 
		
		String message = "Patron " + this.name + " (ID: " + patronID + ") currently has " + this.copiesOut.size() + copyOrCopies + " checked out.";
		for (Copy c : this.copiesOut) {
			message += "\n\t" + c.toString();
		}
		return message;
	}
	
	public static void main(String[] args) {
		Patron p1 = new Patron("P1", "Eric");
		Copy c1 = FakeDB.getCopy("C1");
		Copy c2 = FakeDB.getCopy("C2");
		StdOut.println(">>>No one has anything checked out yet...");
		StdOut.println(p1);
		StdOut.println(c1);
		StdOut.println(c2);
		
		StdOut.println("\n>>>P1 checking out C1 and C2...");
		p1.checkCopyOut(c1);
		StdOut.println(p1);
		p1.checkCopyOut(c2);
		StdOut.println(p1);
		
		StdOut.println("\n>>>P1 checking C1 and C2 back in...");
		p1.checkCopyIn(c2);
		StdOut.println(p1);
		p1.checkCopyIn(c1);
		StdOut.println(p1);
		
		StdOut.println("\n>>>No one has anything checked out...");
		StdOut.println(p1);
		StdOut.println(c1);
		StdOut.println(c2);		
	}
}
