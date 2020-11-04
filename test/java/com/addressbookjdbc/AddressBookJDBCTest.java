package com.addressbookjdbc;

import static org.junit.Assert.assertTrue;

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
}

