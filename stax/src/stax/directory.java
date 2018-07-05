/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ravi.Nistala
 */
public class directory {
     public static void main(String[] args) throws IOException, InterruptedException {
       directory d=new directory();
       Path curdir=Paths.get(".");
       //Path p2="\\input";
       Path p= Paths.get("C:\\FileMonitor\\input");
       //loop 10 times and wait 5 seconds in between
       int loop=1;
       while(loop<=10){
       d.listSourceFiles(p);
       Thread.currentThread().sleep(5000);
       loop+=1;
       }
     }
     
        //List<Path> listSourceFiles(Path dir) throws IOException {
     void listSourceFiles(Path dir) throws IOException {
       //List<Path> result = new ArrayList<Path>();
       try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
           for (Path entry: stream) {
               System.out.println("entry: "+entry);
         //      result.add(entry);
           }
       } catch (DirectoryIteratorException ex) {
           // I/O error encounted during the iteration, the cause is an IOException
           throw ex.getCause();
       }
       //return result;
   }
    
}
