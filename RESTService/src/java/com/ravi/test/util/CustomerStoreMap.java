/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravi.test.util;

import com.ravi.test.entity.Customer;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Ravi.Nistala
 */
@Singleton
@Named
public class CustomerStoreMap implements Serializable {

    HashMap<Integer, Customer> customerMap;

    @Inject
    public CustomerStoreMap() {
        customerMap = new HashMap<Integer, Customer>();
    }

    @PostConstruct
    public void init() {
        Collections.synchronizedMap(customerMap);
    }

    public void addCustomer(int custId, Customer customer) {
        if (customerMap.get(custId) == null) {
            customerMap.put(custId, customer);
        }
    }

    public Customer getCustomer(int custId) {
        return customerMap.get(custId);
    }
    public HashMap<Integer, Customer> getAllCustomers() {
        return customerMap;
    }

    public void removeCustomer(int custId) {
        customerMap.remove(custId);
    }

    public void updateCustomer(int custId, Customer customer) {
        customerMap.put(custId, customer);
    }

}
