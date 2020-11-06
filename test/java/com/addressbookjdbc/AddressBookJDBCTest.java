package com.addressbookjdbc;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookJDBCTest
{
	//UC16
    @Test
    public void givenAddressBookDataInDB_WhenRetrieved_ShouldMatchCount() throws AddressBookJDBCException
    {
    	List<AddressBookData> addressbookdata;
    	AddressBookService addressBookService = new AddressBookService();
		addressbookdata =addressBookService.readAddressBookData();
		Assert.assertEquals(4, addressbookdata.size());
    }
    //UC17
    @Test
    public void givenAddressBookInDB_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDB() throws AddressBookJDBCException
    {
    	List<AddressBookData> addressbookdata;
    	AddressBookService addressBookService = new AddressBookService();
		addressbookdata =addressBookService.readAddressBookData();
		addressBookService.updateContactDetails("Kanishk","Karnataka",22100);
		boolean result=addressBookService.checkAddressBookInSyncWithDB("Kanishk");
		Assert.assertTrue(result);
    }
    //UC18
    @Test
    public void givenAddressBookDataInDB_WhenRetrievedForGivenDate_ShouldSyncWithDB() throws AddressBookJDBCException
    {
    	List<AddressBookData> addressbookdata;
    	AddressBookService addressBookService = new AddressBookService();
		addressbookdata =addressBookService.readAddressBookData();
		LocalDate startDate = LocalDate.parse("2018-01-31");
		LocalDate endDate = LocalDate.parse("2019-01-31");
		List<AddressBookData> matchingRecords = addressBookService
				.getEmployeePayrollDataByStartDate(startDate, endDate);
		Assert.assertEquals(matchingRecords.get(0),addressBookService.getAddressBookData("Kanishk"));
    }
    //UC19
    @Test
    public void givenAddressBookDataInDB_WhenRetrievedUsingCityOrState_ShouldgeveCorrectCount() throws AddressBookJDBCException
    {
    	List<AddressBookData> addressbookdata;
    	AddressBookService addressBookService = new AddressBookService();
		addressbookdata=addressBookService.getContactsByCityOrState("Varanasi","MP");
		Assert.assertEquals(2,addressbookdata.size());
    }
    //UC20
    @Test
    public void givenAddressBookinDB_ShouldAddNewContactToAddressBook() throws AddressBookJDBCException{
    	List<AddressBookData> addressbookdata;
    	AddressBookJDBCService  addressBookJDBCService=new AddressBookJDBCService();
    	AddressBookService addressBookService = new AddressBookService();
    	addressBookJDBCService.addContactEntryToDB("Mauyr","raina","ssd-324","Pune","Maharashtra",
    			2123,98359834,"kanishk@dsds.com",Date.valueOf("2020-02-30"),"School","Friends");
    	boolean result=addressBookService.checkAddressBookInSyncWithDB("Suresh");
    	Assert.assertTrue(result);
    }
    //UC21
    @Test
    public void 
}

