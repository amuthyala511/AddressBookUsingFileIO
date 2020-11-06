package com.blz.file.io;

public class Person
{
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public int zip;
	public long phno;
	public String emailId;
	
	public Person(String firstName, String lastName, String address, String city, String state, int zip, long phno, String emailId)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phno = phno;
		this.emailId = emailId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public int getZip()
	{
		return zip;
	}
	public void setZip(int zip)
	{
		this.zip = zip;
	}
	public long getPhNo()
	{
		return phno;
	}
	public void setPhNo(long phno)
	{
		this.phno = phno;
	}
	public String getEmailId()
	{
		return emailId;
	}
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	
	@Override
	public String toString()
	{
		return "Person [firstname: "+firstName+", lastname: "+lastName+", address: "+address+", city: "+city+", state: "+state+", zip: "+zip
				+", phoneNumber: "+phno+", email: "+emailId+" ]";
	}
}
