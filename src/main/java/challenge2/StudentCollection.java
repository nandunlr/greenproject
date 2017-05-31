package challenge2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 
 * @author Narendra
 *
 */
public class StudentCollection {

	private static Logger logger = Logger.getLogger(StudentCollection.class);
	private static List<Student> studentList=new ArrayList<Student>();
	
	public static void insertStudent(Student student)
	{
		addStudent(student);
	}
	
	public static void displayStudents()
	{
		for(Student student:getStudentList())
		{
			System.out.println(student);
		}
	}
	
	public static void main(String a[])
	{
		Student e1=new Student();
		e1.setId(100);
		e1.setName("Lee More");
		e1.setPhoneNo("480-XXX-YYYY");
		List<Address> addresses1=new ArrayList<Address>();
		Address address1=new Address();
		address1.setAddressLine1("Summerwood Apt");
		address1.setAddressLine2("APT #31");
		address1.setCity("Nashville");
		address1.setCountry("USA");
		address1.setState("TN");
		address1.setZipCode("84129");
		addresses1.add(address1);		
		e1.setAddress(addresses1);
		insertStudent(e1);
		
		Student e2=new Student();
		e2.setId(101);
		e2.setName("Cory Reily");
		e2.setPhoneNo("812-XXX-XXXX");
		List<Address> addresses2=new ArrayList<Address>();
		Address address2=new Address();
		address2.setAddressLine1("Sierra Ranch");
		address2.setAddressLine2("Bell Rd");
		address2.setCity("Phoenix");
		address2.setCountry("USA");
		address2.setState("AZ");
		address2.setZipCode("85032");
		addresses2.add(address2);		
		e2.setAddress(addresses2);
		insertStudent(e2);
		
		displayStudents();
	}

	/**
	 * @return the StudentList
	 */
	public static List<Student> getStudentList() {
		Collections.unmodifiableList(studentList);
		return studentList;
	}

	/**
	 * @param StudentList the StudentList to set
	 */
	public static void addStudent(Student student) {
		studentList.add(student);
	}
}
