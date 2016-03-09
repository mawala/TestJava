package EasyMock;

public class Person {
	private int id;
	private String firstName;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(){
		
	}
	public Person(int id, String name, int ageA){
		this.id = id;
		this.firstName = name;
		this.age = ageA;
	}
	
}
