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
public class LocalStoreMap  implements Serializable{
HashMap<Integer, String> localMap;
    

    @Inject
    public LocalStoreMap() {
        localMap = new HashMap<Integer, String>();
        
    }

    

    @PostConstruct
    public void init() {
        //creating only one instance of HashMap here

        Collections.synchronizedMap(localMap);
        localMap.put(1, "one");
        localMap.put(2, "two");
        localMap.put(3, "three");
        localMap.put(4, "four");
        localMap.put(5, "one");
    }

    public void storeValue(int key, String Value) {
        System.out.println("storeValue -  key : "+key+"   value:  "+Value);
        localMap.put(key, Value);
    }

    public String getValue(int key) {
        return localMap.get(key);
    }
    
    public String removeValue(int key) {
        System.out.println("removeValue -  key : "+key);
        return localMap.remove(key);
    }
    
    public String updateValue(int key,String value) {
        System.out.println("updateValue -  key : "+key+"   value:  "+value);
        return localMap.put(key,value);
    }

}
