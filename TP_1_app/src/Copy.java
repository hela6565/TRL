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
public class Copy {
	private String copyID;
	private String title;
	private Patron outTo;

	public Copy(String copyID, String title) {
		this.copyID = copyID;
		this.title = title;
	}	
	
	public String getCopyID() {
		return copyID;
	}

	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Patron getOutTo() {
		return this.outTo;
	}

	public void setOutTo(Patron outTo) {
		this.outTo = outTo;
	}

	public String toString() {
		if (this.outTo == null) {
			return "" + this.title + " (ID: " + copyID + ") is not checked out.";
		} else {
			return "" + this.title + " (ID: " + copyID + ") is checked out to " + this.getOutTo().getPatronID() + ".";
		}
	}

	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof Copy))
			return false;
		
		Copy c = (Copy) o;
		
		if (c.copyID.equals(this.copyID)) {
			return true;
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		Copy c1 = new Copy("C1", "Fun with Objects");
		Patron p1 = new Patron("Eric", "P47");

		System.out.println(c1);
		System.out.println(p1);

		Copy c2 = FakeDB.getCopy("C2");
		
		System.out.println(c2);
		
	}
}
