/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravi.test.services;

import com.ravi.test.entity.Customer;
import com.ravi.test.util.CustomerStoreMap;
import com.ravi.test.util.LocalStoreMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/**
 *
 * @author Ravi.Nistala
 */
public class CustomerServices {

    @Inject
    private LocalStoreMap localMap;

    @Inject
    private CustomerStoreMap custMap;

    public String getValue(int Id) {
        String response = localMap.getValue(Id);
        if (response == null) {
            return "VALUE NOT FOUND!!";
        } else {
            return response;
        }
    }

    public String addValue(int Id, String value) {
        String response = localMap.getValue(Id);
        if (response == null) {
            localMap.storeValue(Id, value);
            return "VALUE ADDEDD SUCCESSFULLY!!";
        } else {
            return "RECORD ALREADY EXISTS!!";
        }
    }

    public String updateValue(int Id, String value) {
        String response = localMap.getValue(Id);
        if (response == null) {
            return "VALUE NOT FOUND!!";
        } else {
            localMap.updateValue(Id, value);
            return "VALUE UPDATED";
        }
    }

    public String deleteValue(int Id) {
        String response = localMap.getValue(Id);
        if (response == null) {
            return "VALUE NOT FOUND!!";
        } else {
            localMap.removeValue(Id);
            return "VALUE DELETED";
        }
    }
//Customer Services

    public Customer getCustomer(int custId) {

        Customer response = custMap.getCustomer(custId);
        if (response == null) {
            return null;
        } else {
            return response;
        }
    }

    public String addCustomer(Customer customer) {
        Customer response = custMap.getCustomer(customer.getCustId());

        if (response == null) {
            custMap.addCustomer(customer.getCustId(), customer);
            return "Customer Successfully Added!!";
        } else {
            return "Customer already Exists";
        }

    }

    public String deleteCustomer(int custId) {

        Customer response = custMap.getCustomer(custId);
        if (response == null) {
            return "Customer Does not Exist!!";
        } else {
            custMap.removeCustomer(custId);
            return "Customer Successfully Deleted";
        }
    }

    public String updateCustomer(Customer customer) {

        Customer response = custMap.getCustomer(customer.getCustId());
        if (response == null) {
            return "Customer Does not Exist!!";
        } else {
            custMap.updateCustomer(customer.getCustId(), customer);
            return "Customer Updated Successfully !!";
        }
    }

    public Customer[] getAllCustomers() {
        Customer[] customers = new Customer[custMap.getAllCustomers().size()];
        Set<Integer> customerIds = custMap.getAllCustomers().keySet();

        Iterator custIt = customerIds.iterator();
        int i = 0;
        while (custIt.hasNext()) {
            Customer cust = custMap.getCustomer((Integer) custIt.next());
            customers[i] = cust;
            i++;
        }

        return customers;

    }

}
