package springexample.ex01;

public class Triangle {
	private String type;
	private String message;
	private int id;
	
	public Triangle(String type, String message, int id){
		this.type = type;
		this.message = message;
		this.id = id;
	}
	
	// second constructor, to test 
	public Triangle(String type, int id){
		this.type = type;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw(){
		System.out.println(getType()+" Triangle drawn, with message: "+getMessage()+" and ID no.: "+getId());
	}

}
