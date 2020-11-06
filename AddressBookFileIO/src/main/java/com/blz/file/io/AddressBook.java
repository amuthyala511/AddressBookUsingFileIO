package com.blz.file.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	static Scanner sc = new Scanner(System.in);

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	public static List<Person> personList;

	public AddressBook(List<Person> personList) {
		super();
		this.personList = personList;
	}

	public static void addContact() {
		System.out.println("Enter first name: ");
		String firstName = sc.next();
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equals(firstName)) {
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
		String zip = sc.next();
		System.out.println("Enter Phone Number: ");
		String phno = sc.next();
		System.out.println("Enter email address: ");
		String emailId = sc.next();
		Person p = new Person(firstName, lastName, address, city, state, zip, phno, emailId);
		personList.add(p);
	}

	public static void editContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name : ");
		String firstName = sc.nextLine();
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
				personList.remove(i);
				addContact();
			} else {
				System.out.println("No data found");
			}
		}
	}

	public void deleteDetails() {
		System.out.println("Enter first name: ");
		String firstName = sc.next();
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
				personList.remove(i);
			} else {
				System.out.println("No matches found");
			}
		}
	}

	public void addPerson() {
		System.out.println("Enter number of persons to be added to the address book: ");
		int noOfPersons = sc.nextInt();
		int count = 1;
		while (count <= noOfPersons) {
			addContact();
			count++;
		}
	}

	public void searchByCity() {
		System.out.println("Enter city name: ");
		String city = sc.next();
		personList.stream().filter(n -> n.getCity().equals(city))
				.forEach(i -> System.out.println("Result: " + i.getFirstName()));
	}

	public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new AddressBookFileIOService().countEntries(ioService);
		return 0;
	}

	public static void writeAddressBookData(IOService ioService) {
		if (ioService.equals(com.blz.file.io.AddressBook.IOService.CONSOLE_IO))
			System.out.println("Employee Payroll to Details : " + personList);
		if (ioService.equals(com.blz.file.io.AddressBook.IOService.FILE_IO))
			new AddressBookFileIOService().writeData(personList);
	}

	public void readDataFromFile() {
		System.out.println("Enter address book name: ");
		String addressBookFile = sc.nextLine();
		Path filePath = Paths.get("C:\\Users\\Muthyala Aishwarya\\git" + addressBookFile + ".txt");
		try {
			Files.lines(filePath).map(line -> line.trim()).forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}