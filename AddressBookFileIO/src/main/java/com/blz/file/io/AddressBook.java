package com.blz.file.io;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook
{
	Scanner sc = new Scanner(System.in);
	public static List<Person> personList = new ArrayList<Person>();
	
	public void addContact()
	{
		System.out.println("Enter first name: ");
		String firstName = sc.next();
		for(int i = 0; i < personList.size(); i++)
		{
			if(personList.get(i).getFirstName().equals(firstName))
			{
				System.out.println("Name already exists. Enter new name");
				addContact();
				break;
			}
		}
		System.out.println("Enter last name: ");
		String lastName = sc.next();
		System.out.println("Enter address: ");
		String address = sc.next();
		System.out.println("Enter city: ");
		String city = sc.next();
		System.out.println("Enter state: ");
		String state = sc.next();
		System.out.println("Enter zipcode: ");
		int zip = sc.nextInt();
		System.out.println("Enter Phone Number: ");
		long phno = sc.nextLong();
		System.out.println("Enter email address: ");
		String emailId = sc.next();
		Person p = new Person(firstName, lastName, address, city, state, zip, phno, emailId);
		personList.add(p);
	}
	public void deleteDetails()
	{
		System.out.println("Enter first name: ");
		String firstName = sc.next();
		for(int i = 0; i < personList.size(); i++)
		{
			if(personList.get(i).getFirstName().equalsIgnoreCase(firstName))
			{
				personList.remove(i);
			}
			else
			{
				System.out.println("No matches found");
			}
		}
	}
	public void addPerson()
	{
		System.out.println("Enter number of persons to be added to the address book: ");
		int noOfPersons = sc.nextInt();
		int count = 1;
		while(count <= noOfPersons)
		{
			addContact();
			count++;
		}
	}
	public void searchByCity()
	{
		System.out.println("Enter city name: ");
		String city = sc.next();
		personList.stream().filter(n -> n.getCity().equals(city))
				.forEach(i -> System.out.println("Result: "+i.getFirstName()));
	}
	public void viewByCity()
	{
		System.out.println("Enter city name: ");
		String city = sc.next();
		personList.stream().filter(n -> n.getCity().equals(city))
				.forEach(i -> System.out.println(i));
	}
	public void countBasedOnCity()
	{
		int count = 0;
		System.out.println("Enter city name: ");
		String city = sc.next();
		count = (int) personList.stream().filter(n -> n.getCity().equals(city)).count();
		System.out.println(count);
	}
	public void sortByName()
	{
		personList = personList.stream().sorted(Comparator.comparing(Person :: getFirstName))
					.collect(Collectors.toList());
		personList.forEach(i -> System.out.println(i));
	}
	public void sortByCity()
	{
		personList = personList.stream().sorted(Comparator.comparing(Person :: getCity))
					.collect(Collectors.toList());
		personList.forEach(i -> System.out.println(i));
	}
	public static void main(String[] args)
	{
		AddressBook adrBook = new AddressBook();
		System.out.println("Welcome to the Address Book Problem");
		adrBook.addContact();
		System.out.println(personList);
	}
}
