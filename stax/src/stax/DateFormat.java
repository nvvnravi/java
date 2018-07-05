
import java.io.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    private final static long DIFF_NET_JAVA_FOR_DATE_AND_TIMES = 11644473600000L;
    private static final SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private static final SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
    private static final SimpleDateFormat AD_CREATION_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat AD_DATE_FORMAT_2 = new SimpleDateFormat("MM/dd/yyyyHH:mm:ss");

    public static void main(String[] args) throws Exception {

        String inputCreateDate = "20140107031942.0Z";
        Date outputCreateDate = new Date();

        String inputResetDate = "130933862541854603";
        Date outputResetDate = new Date();

        Date outputDate = new Date();
        System.out.println("date-1");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'");

        Timestamp ts = getTimeStampValue("2018-01-01");
        System.out.println(ts);

        System.out.println(toISO8601UTC(ts));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //log.debug("### getTimeStampValue  before parse.");
        java.util.Date date = sdf.parse("2018-01-01 00:00:00.0");

        System.out.println("System Date in GMT: " + formatDateToString(new java.sql.Timestamp(date.getTime()), "dd MMM yyyy hh:mm:ss.SSS ", "GMT"));

        System.out.println("date-2");
        try {
            System.out.println("Starting");

            System.out.println("## INPUT CREATE DATE : " + inputCreateDate);
            outputCreateDate = convertDateTo_MMDDYYYYHHMMSS(inputCreateDate);
            System.out.println("## FORMATED CREATE DATE : " + outputCreateDate);

            System.out.println("## INPUT RESET DATE : " + inputResetDate);
            outputResetDate = convertDateTo_MMDDYYYYHHMMSS(inputResetDate);
            System.out.println("## FORMATED RESET DATE : " + outputResetDate);

            System.out.println("## output RESET DATE-start : " + inputResetDate);

            System.out.println("## output RESET DATE-end : " + outputDate(inputResetDate));

            System.out.println("## output create DATE-start : " + inputCreateDate);
            System.out.println("## output create DATE-end : " + parseADAccountCreationDate(inputCreateDate.substring(0, 13)));

            //
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sdate = sdf.format(new Date());
            System.out.println("## current date : " + sdate);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -1);
            System.out.println("## 1 year back date : " + sdf.format(calendar.getTime()));
                        
            sortMap();
            
            
             sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse("2018-04-01 00:00:00");
             System.out.println(sdf.format(date));

        } catch (Exception ignore) {
        }

    }

    private static Date parseDateForTimestamp(String date, String time) {
        Date parsedDate = null;
        try {
            String fullDate = date + " " + time;
            parsedDate = INPUT_DATE_FORMAT.parse(fullDate);
        } catch (Exception e) {
        }
        return parsedDate;
    }

    private static String parseADAccountCreationDate(String date) {
        System.out.println("## Inside parseADAccountCreationDate()....");
        String reportDate = null;

        try {

            reportDate = OUTPUT_DATE_FORMAT.format(AD_CREATION_DATE_FORMAT.parse(date));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return reportDate;

    }

    private long parseADPasswordResetDate(String date, String time) {

        long adDateTime = 0;

        Date parseDate = this.parseDateForTimestamp(date, time);
        adDateTime = (parseDate.getTime() + DIFF_NET_JAVA_FOR_DATE_AND_TIMES) * 10000;

        return adDateTime;
    }

    /* Following method is used to format date received/processed from AD before displaying in Audit GUI. */
    public static Date convertDateTo_MMDDYYYYHHMMSS(String adDate) {

        Date convertedDate = null;
        Date resultDate = null;
        String date = null;
        try {
            long adDateTime = Long.parseLong(adDate);
            long milliseconds = (adDateTime / 10000) - DIFF_NET_JAVA_FOR_DATE_AND_TIMES;
            convertedDate = new Date(milliseconds);
            date = INPUT_DATE_FORMAT.format(convertedDate);
            resultDate = INPUT_DATE_FORMAT.parse(date);
        } catch (Exception e) {
        }
        return resultDate;
    }

    public static String outputDate(String adDate) {

        String resultDate = null;

        try {
            resultDate = OUTPUT_DATE_FORMAT.format(convertDateTo_MMDDYYYYHHMMSS(adDate));
        } catch (Exception e) {
            System.out.println("## Exception in outputDate : " + e.getMessage());
        }
        return resultDate;
    }

    public static Timestamp cvtToGMT(Timestamp ts) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        long utcMiliseconds = ts.getTime();
        Date localTime = new Date(utcMiliseconds + cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET));

        return new Timestamp(localTime.getTime());
    }

    private static Timestamp getTimeStampValue(String inputString) {

        java.sql.Timestamp timest = null;
        System.out.println("### getTimeStampValue  before conversion :" + inputString);
        try {
            if (inputString != null && inputString.length() > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //log.debug("### getTimeStampValue  before parse.");
                java.util.Date date = sdf.parse(inputString);
                //log.debug("### getTimeStampValue  after parse parse.");
                timest = new java.sql.Timestamp(date.getTime());
                //log.debug("### getTimeStampValue  after assigning value to sql.timestamp..");
            }
            System.out.println("### getTimeStampValue  after conversion:" + timest);
            return timest;
        } catch (ParseException e) {
            return timest;
        }
    }

    public static Timestamp toISO8601UTC(Timestamp date) throws ParseException {
        java.sql.Timestamp timest = null;
        TimeZone tz = TimeZone.getTimeZone("UTC");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        df.setTimeZone(tz);
        java.util.Date date1 = df.parse(df.format(date));
        //log.debug("### getTimeStampValue  after parse parse.");
        timest = new java.sql.Timestamp(date1.getTime());
        return timest;
    }

    public static String formatDateToString(Timestamp date, String format,
            String timeZone) {
        // null check
        if (date == null) {
            return null;
        }
        // create SimpleDateFormat object with input format
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // default system timezone if passed null or empty
        if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
            timeZone = Calendar.getInstance().getTimeZone().getID();
        }
        // set timezone to SimpleDateFormat
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        // return Date in required format with timezone as String
        return sdf.format(date);
    }

    static void sortMap() throws Exception{
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    TreeMap<Date, Integer> map = new TreeMap<Date, Integer>(new Comparator<Date>() {
        public int compare(Date date1, Date date2) {
            return date2.compareTo(date1);
        }
    });

    map.put(dateFormat.parse("2010-02-01"), 1);
    map.put(dateFormat.parse("2011-03-05"), 2);
    map.put(dateFormat.parse("2012-04-10"), 3);
    map.put(dateFormat.parse("2013-05-21"), 4);
    map.put(dateFormat.parse("2013-05-26"), 5);
    map.put(dateFormat.parse("2014-06-26"), 6);
    map.put(dateFormat.parse("2015-10-26"), 7);
    map.put(dateFormat.parse("2009-12-11"), 1);
    map.put(dateFormat.parse("2011-11-26"), 8);
     System.out.println(" last key value   :"+ map.lastKey());
     System.out.println(" last key value   :"+ map.get(map.lastKey()));
     map.remove(map.lastKey());
     System.out.println(" last key value   :"+ map.lastKey());
     System.out.println(" last key value   :"+ map.get(map.lastKey()));
    Set s = map.entrySet();
Iterator i = s.iterator();
//if (i.hasNext()) {
 //   System.out.println(" first key   :"+ i.next());
 //   System.out.println(" first value   :"+ map.get(i.next()));
//}

   
}
    
}
