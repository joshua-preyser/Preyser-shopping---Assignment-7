package com.josh.factory.customer;

import com.josh.domain.customer.Customer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class CustomerFactoryTest
{
    private String testName;
    @Before
    public void setUp() throws Exception
    {
        this.testName = "testName";
    }

    @Test
    public void buildCustomer()
    {
        Customer customer=  CustomerFactory.buildCustomer(idd, address, phone, email);
        Assert.assertNotNull(customer.getId());
        Assert.assertNotNull(customer.getAddress());
        Assert.assertNotNull(customer.getphone());
        Assert.assertNotNull(customer.getEmail());
        Assert.assertNotNull(customer);
    }
}