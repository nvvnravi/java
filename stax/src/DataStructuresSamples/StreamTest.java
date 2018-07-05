/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Ravi.Nistala
 */
public class StreamTest {
      public static void main(String[] args) {
          List<person> persons=new ArrayList<person>();
          person p1=new person("first",23);
          persons.add(p1);
          p1=new person("second",35);
          persons.add(p1);
          p1=new person("third",37);
          persons.add(p1);
          p1=new person("fourth",38);
          persons.add(p1);
          p1=new person("five",47);
          persons.add(p1);
          
          persons.parallelStream().forEach((person element) -> {
              System.out.println(element.getName());
              System.out.println("    :    ");
              System.out.println(element.getAge());
          });
          
      }
    
    
}

class person{
    private String name;
    private int age;
    
    public person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
