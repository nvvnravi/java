/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructuresSamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *
 * @author Ravi.Nistala
 */
public class arraylisttest {
    
    public static void main (String[] args) throws Exception {
    List<String> nameList=new ArrayList<String>();
    nameList.add("name1");nameList.add("name2");nameList.add("name3");nameList.add("name4");nameList.add("name5");
    System.out.println("   Lambda  ");
    nameList.forEach(item->System.out.println(item));
    System.out.println("   Method Reference  ");
    nameList.forEach(System.out::println);
       
    //Consumaer functional interface
   nameList.forEach(new Consumer<String>(){
    public void accept(String name){
  //      System.out.println("   Consumer "+name);
    }   
   } );
   
  //System.out.println("   String.join   "+String.join("-","1","2","3","4","5"));
  
  //String s1="test";
  //System.out.println("   s1.join   "+s1.join("-","a","b","c"));
  
  StringJoiner sj=new StringJoiner("-","start-","-end");
  sj.add("a");
  sj.add("b");
  sj.add("c");
  sj.add("d");
  sj.add("e");
  sj.add("f");
  sj.add("g");
  sj.add("h");
  System.out.println("   sj:   "+sj);
  arraylisttest s2=new arraylisttest();
  s2.test();
    }
    
    
    void test(){

        List<Game> list = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5)
        );

        //{Dragon Blaze, Angry Bird, Candy Crush}
        String result = list.stream().map(x -> x.getName())
			.collect(Collectors.joining(", ", "{", "}"));
        
        
        System.out.println("  result   "+result);
    }
    
   class Game{
        String name;
        int ranking;

        public Game(String name, int ranking) {
            this.name = name;
            this.ranking = ranking;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }
    }
    
}
