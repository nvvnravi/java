/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

/**
 *
 * @author Ravi.Nistala
 */
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
public class AD
{
        private static final Character LONGVARIABLE = 'L';    
public void converADdateToOIMdate(long ADdate){

long ADdate1 = Long.parseLong(String.valueOf(ADdate));
System.out.println("long value : "+ADdate1);

// Filetime Epoch is 01 January, 1601
// java date Epoch is 01 January, 1970
// so take the number and subtract java Epoch:
long javaTime = ADdate1 - 0x19db1ded53e8000L;

// convert UNITS from (100 nano-seconds) to (milliseconds)
javaTime /= 10000;

// Date(long date)
// Allocates a Date object and initializes it to represent
// the specified number of milliseconds since the standard base
// time known as "the epoch", namely January 1, 1970, 00:00:00 GMT.
Date theDate = new Date(javaTime);


System.out.println("java DATE value : "+theDate);

SimpleDateFormat formatter = new SimpleDateFormat("MMMMM d, yyyy");
// change to GMT time:
//formatter .setTimeZone(TimeZone.getTimeZone("GMT"));

String newDateString = formatter.format(theDate);

System.out.println("Date changed format :" + newDateString);

final long aDDate1 = Long.parseLong("130893223345619996");
 final long dateConstant = 0x19db1ded53e8000L;
        long javaTime1 = aDDate1 - dateConstant;

System.out.println("long type of days 222:" + javaTime1);
}


public static void main(String[] args)
{
AD d=new AD();
d.converADdateToOIMdate(130841689096826885L);
// 9223372036854775807
// 127948319499226601

}
}
