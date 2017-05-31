package challenge2;

import java.util.Collections;
import java.util.List;


public class Employee {

	private Integer id;
	
	private String name;
	 
	private String phoneNo;
	
	private List<Address> address;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
	    Collections.unmodifiableList(address);
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String toString()
	{
		return "Id:"+this.id+",Name:"+this.name+",phoneNo:"+this.phoneNo+",Addresses:"+this.address;
	}
}
