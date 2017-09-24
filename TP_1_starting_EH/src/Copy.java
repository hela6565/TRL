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
	public String getCopyID() {
		return copyID;
	}

	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Patron getOutTo() {
		return outTo;
	}

	public void setOutTo(Patron outTo) {
		this.outTo = outTo;
	}

	private String copyID;
	private String title;
	private Patron outTo;

	public Copy(String copyID, String title) {
		this.copyID = copyID;
		this.title = title;
//		FakeDB.putCopy(copyID,  title);
	}

	public String toString() {
//		if (this.outTo == null) {
//			return "" + this.title + " (ID: " + copyID + ") is not checked out.";
//		} else {
			return "" + this.title + " (ID: " + copyID + ")";// is checked out to " + this.getOutTo() + ".";
//		}
	}

	@Override
	public boolean equals(Object o) {
		
		//Copy is equal if copyID string is equal
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
