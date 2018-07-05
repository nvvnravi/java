package com.test.servicemonitor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ravi.Nistala
 */
public class CheckServerService {

    private String host = "localhost";
    private int port = 8080;
    private int timeout = 30000;
    private int sleepTime = 1800000;
 

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //Read configuration file

        Thread t1 = new Thread(new MyRunnable(), "t1");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     
        System.out.println(" After thread Join");
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread started:::" + Thread.currentThread().getName());
        try {
          //  while (!Thread.currentThread().interrupted()) {
                Thread.sleep(500);
                System.out.println(" Calling PingHost...");
                if(pingHost("localhost",8080,5000))System.out.println(" Host can be Pinged. ");
                else System.out.println(" Host cannot be Pinged. ");
                System.out.println(" Calling PingURL...");
                Thread.sleep(500);
                if(pingURL("http://localhost:8080/CalculatorApp/CalculatorWSService?wsdl",5000))System.out.println(" URL can be Pinged and opened. ");
                else System.out.println(" URL cannot be opened. Application may be down ");
           // }
            //Thread.sleep(10000);
            //Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::" + Thread.currentThread().getName());
    }

    public static boolean pingHost(String host, int port, int timeout) {
        Socket socket = new Socket();
    
        try {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            //exception in connecting     
            //need to send email
            return false; // Either timeout or unreachable or failed DNS lookup.
        }finally{
            try{
        
            socket.close();
            }catch(IOException e){
                //exception in closing connection
            }
        }
    }

    /**
     * Pings a HTTP URL. This effectively sends a HEAD request and returns
     * <code>true</code> if the response code is in the 200-399 range.
     *
     * @param url The HTTP URL to be pinged.
     * @param timeout The timeout in millis for both the connection timeout and
     * the response read timeout. Note that the total timeout is effectively two
     * times the given timeout.
     * @return <code>true</code> if the given HTTP URL has returned response
     * code 200-399 on a HEAD request within the given timeout, otherwise
     * <code>false</code>.
     */
    public static boolean pingURL(String url, int timeout) {
        //url = url.replaceFirst("^https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.
        //HttpsURLConnection connection = null;
        HttpURLConnection connection=null;
        try {
            URL myurl = new URL(url);
           // connection = (HttpsURLConnection) myurl.openConnection();

            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            //exception in making connection
            //need to send email.
            return false;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    }
