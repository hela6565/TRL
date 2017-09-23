
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
		return false;
	}

	public boolean checkCopyIn(Copy c) {
//		c.setOutTo(null);
//		System.out.println("Before...");
//		for (Copy copy : this.copiesOut) {
//			System.out.println(copy.toString());
//		}
		this.copiesOut.remove(c);
		return true;
//		System.out.println("After...");
//		for (Copy copy : this.copiesOut) {
//			System.out.println(copy.toString());
//		}
//		return false;
	}

	@Override
	public boolean equals(Object o) {
		return this.toString() == o.toString();
	}

	public String toString() {
		String message = "Patron " + this.name + " (ID: " + patronID + ") currently has " + this.copiesOut.size() + " copies checked out.";
		for (Copy c : this.copiesOut) {
			message += c.toString();
		}
		return message;
	}

	public static void main(String[] args) {
		Patron p1 = new Patron("P1", "Eric");

		System.out.println(p1);

		Patron p2 = FakeDB.getPatron("P1");
		Copy c1 = FakeDB.getCopy("C1");
		Copy c2 = FakeDB.getCopy("C2");
		
		p1.checkCopyOut(c1);
		System.out.println(p1);
		p1.checkCopyOut(c2);
		System.out.println(p1);
		
		p1.checkCopyIn(c2);
		System.out.println(p1);
		p1.checkCopyIn(c1);
		System.out.println(p1);		
		
//		
//		Copy c3 = new Copy("C1", "Fun with Objects");
//		Patron p3 = new Patron("Eric", "P47");
//
//		System.out.println(c3);
//		System.out.println(p3);
//
//		Copy c4 = FakeDB.getCopy("C2");
//		
//		System.out.println(c4);
		
	}

}
