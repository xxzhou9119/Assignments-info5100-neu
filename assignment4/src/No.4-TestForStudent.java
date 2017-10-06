import java.util.ArrayList;
//No.4:
public class TestForStudent {
	public static void main(String args[]) {
		Student s = new Student("zoe","001" );
		Course c = new Course("Java");
		System.out.println(c.isFull());
		c.registerStudent(s);
		System.out.println(c.isFull());
		System.out.println(c.getStudents().size());
	}
}
	class Student{
		private String name;
		private String id;
	
	public Student(String name,String id){
		this.name=name;
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	}
	
	class Course{
		private String name;
		private int numberOfStudent;
		public ArrayList<Student> Students;
		
		
		public Course(String name){
			this.name=name;
			this.numberOfStudent=0;
			this.Students=new ArrayList<Student>();
		}
		public void setName(String name){
			this.name=name;
		}
		public String getName(){
			return name;
		}
		
		public int getNumberOfStudent(){
			this.numberOfStudent= Students.size();
			return numberOfStudent;
		}
		
		public ArrayList<Student> getStudents(){
			
			return Students;	
		}
		
		public boolean isFull(){
			if(this.Students.size()==10){
				return true;
			}
			return false;
		}
		public void registerStudent(Student student){
			if(!this.isFull()){
				this.Students.add(student);
			}else{
				System.out.println("This course is full, please register another course!");
			}
		}
	}


