package challenge2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;

public class EmployeeCollection {

	private static Logger logger = Logger.getLogger(EmployeeCollection.class);
	private static List<Employee> employeeList=new ArrayList<Employee>();
	
	public static void insertEmployee(Employee employee)
	{
		addEmployee(employee);
	}
	
	public static void displayEmployees()
	{
		for(Employee employee:getEmployeeList())
		{
			System.out.println(employee);
		}
	}
	
	public static void main(String a[])
	{
		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("Rak");
		e1.setPhoneNo("98652552255");
		List<Address> addresses1=new ArrayList<Address>();
		Address address1=new Address();
		address1.setAddressLine1("No 8/9,Tnk");
		address1.setAddressLine2("Ramuni");
		address1.setCity("zebh");
		address1.setCountry("c1");
		address1.setState("zx");
		address1.setZipCode("6588869");
		addresses1.add(address1);		
		e1.setAddress(addresses1);
		insertEmployee(e1);
		
		Employee e2=new Employee();
		e2.setId(2);
		e2.setName("Trh");
		e2.setPhoneNo("965882225");
		List<Address> addresses2=new ArrayList<Address>();
		Address address2=new Address();
		address2.setAddressLine1("No 8/9,Tnk");
		address2.setAddressLine2("Ramuni");
		address2.setCity("zebh");
		address2.setCountry("c1");
		address2.setState("zx");
		address2.setZipCode("6588869");
		addresses2.add(address2);		
		e2.setAddress(addresses2);
		insertEmployee(e2);
		
		displayEmployees();
	}

	/**
	 * @return the employeeList
	 */
	public static List<Employee> getEmployeeList() {
		Collections.unmodifiableList(employeeList);
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public static void addEmployee(Employee employee) {
		employeeList.add(employee);
	}
}
