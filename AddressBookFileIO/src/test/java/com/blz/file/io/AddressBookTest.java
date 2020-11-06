package com.blz.file.io;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddressBookTest {
	static AddressBook addressBook;
	
	@BeforeClass
	public static void createAddressBookObj() {
		addressBook = new AddressBook(null);
	}
	@Test
	public void given2EmployeeDetails_whenWrittenToFile_ShouldMatchWithEntries() {
		Person[] arrayOfEmps = { new Person("Aishwarya", "Muthyala", "rmngr", "knr", "Tg", "505001", "9876543210", "aish@gmail.com"),
				new Person("Panu", "Muthyala", "algnr", "knr", "Tg", "505002", "9123456780", "panu@gmail.com")
		};
		addressBook = new AddressBook(Arrays.asList(arrayOfEmps));
		AddressBook.writeAddressBookData(com.blz.file.io.AddressBook.IOService.FILE_IO);
		long entries = AddressBookFileIOService.countEntries(com.blz.file.io.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(2, entries);
	}
}
