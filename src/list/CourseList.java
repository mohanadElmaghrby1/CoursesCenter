package list;


import Course.Course;
import javafx.beans.property.*;

public class CourseList {

	private  SimpleIntegerProperty id;
	public int getId() {
		return id.get();
	}

	public void setId(SimpleIntegerProperty id) {
		this.id = id;
	}

	public String getSubject() {
		return subject.get();
	}

	public void setSubject(SimpleStringProperty subject) {
		this.subject = subject;
	}

	public String getInstructorId() {
		return instructorId.get();
	}

	public void setInstructorId(SimpleStringProperty instructorId) {
		this.instructorId = instructorId;
	}

	public String getCreateDate() {
		return createDate.get();
	}

	public void setCreateDate(SimpleStringProperty createDate) {
		this.createDate = createDate;
	}

	public int getHours() {
		return hours.get();
	}

	public void setHours(SimpleIntegerProperty hours) {
		this.hours = hours;
	}

	public int getPrice() {
		return price.get();
	}

	public void setPrice(SimpleIntegerProperty price) {
		this.price = price;
	}

	public int getFreeSpaces() {
		return freeSpaces.get();
	}

	public void setFreeSpaces(SimpleIntegerProperty freeSpaces) {
		this.freeSpaces = freeSpaces;
	}

	public int getNumberOfStudents() {
		return numberOfStudents.get();
	}

	public void setNumberOfStudents(SimpleIntegerProperty numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getStartDate() {
		return startDate.get();
	}

	public void setStartDate(SimpleStringProperty startDate) {
		this.startDate = startDate;
	}

	public int getLap() {
		return lap.get();
	}

	public void setLap(SimpleIntegerProperty lap) {
		this.lap = lap;
	}


	private  SimpleStringProperty subject;
	private  SimpleStringProperty instructorId;
	private  SimpleStringProperty createDate;
	private  SimpleIntegerProperty hours;
	private SimpleIntegerProperty price;
	//private final SimpleIntegerProperty capacity;
	private  SimpleIntegerProperty freeSpaces;
	private  SimpleIntegerProperty  numberOfStudents;
	
	private SimpleStringProperty startDate;
	private SimpleIntegerProperty lap;
	
	public CourseList( int id , String instructorId, String subject, int capacity , int hours , int freeSpaces , int lap ,
			String createDate , String startDate , int numberOfStudents , int price){
		
		this.id = new SimpleIntegerProperty(id);
		this.subject = new SimpleStringProperty(subject);
		this.instructorId = new SimpleStringProperty(instructorId);
		this.createDate=new SimpleStringProperty(startDate);
		this.hours = new SimpleIntegerProperty(hours);
		this.price = new SimpleIntegerProperty(price);
		
	//	this.capacity = new SimpleIntegerProperty(capacity);
		this.freeSpaces = new SimpleIntegerProperty(freeSpaces);
		this.numberOfStudents = new SimpleIntegerProperty(numberOfStudents);
		this.startDate=new SimpleStringProperty(startDate);
		this.lap = new SimpleIntegerProperty(lap);
		
		
		
		
	}
	
	public CourseList(Course course){
		this.id = new SimpleIntegerProperty(course.getCourseId());
		this.subject = new SimpleStringProperty(course.getCourseSubject());
		this.instructorId = new SimpleStringProperty(course.getInstructorId());
		this.createDate=new SimpleStringProperty("0");
		this.hours = new SimpleIntegerProperty(course.getCourseHours());
		this.price = new SimpleIntegerProperty(course.getCoursePrice());
		
	//	this.capacity = new SimpleIntegerProperty(course.getCourseCapacity());
		this.freeSpaces = new SimpleIntegerProperty(course.getCourseFreeSpaces());
		this.numberOfStudents = new SimpleIntegerProperty(course.getCourseCapacity()-course.getCourseFreeSpaces());
		this.startDate=new SimpleStringProperty("0");
		this.lap = new SimpleIntegerProperty(course.getCourseLap());
		
				
		
	}
	
	
	public CourseList( int id) {
		this.id= new SimpleIntegerProperty(id);
	} 
	
}
