package in.ashokit.binding;

public class PetRequest {
	private int id;
	private String petname;
	private String petprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public PetRequest() { super(); // TODO Auto-generated constructor stub }
	 */
	public PetRequest(int id, String petname, String petprice) {
		super();
		this.id = id;
		this.petname = petname;
		this.petprice = petprice;
	}
	public PetRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getPetprice() {
		return petprice;
	}
	public void setPetprice(String petprice) {
		this.petprice = petprice;
	}
	@Override
	public String toString() {
		return "PetRequest [id=" + id + ", petname=" + petname + ", petprice=" + petprice + "]";
	}
	
	

}
