/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stax;

import java.text.MessageFormat;

/**
 *
 * @author Ravi.Nistala
 */
public class patperf {

    public static void main(String[] args) throws Exception {
        String s1 = "'test1@gdit.com','test2@gdit.com'";
        String[] tempProviderAddress = s1.split(",");
         System.out.println(" tempProviderAddress[i]:" + tempProviderAddress.toString());

        String[] params = new String[tempProviderAddress.length - 1];
        int i=0;
        for (String s: tempProviderAddress) {  
            System.out.println(" tempProviderAddress[i]:" + tempProviderAddress[i]);
            params[i] = patperf.checkSingleQuote(s);
            System.out.println(" params[i]:" + params[i]);
        }
        
       

        System.out.println(patperf.getSQL("from LIKE ''%{0}%''  OR hmail.dbo.hm_message", new String[]{"''test1@gdit.com'',''test2@gdit.com''"}));

    }

    public static String checkSingleQuote(String sql) {
        if (sql == null || sql.trim().length() == 0) {
            return sql;
        }
        int index = sql.indexOf("'");
        if (index < 0) {
            return sql;
        }
        StringBuilder buffer = new StringBuilder(sql);
        while (index != -1) {
            buffer.insert(++index, "'");
            index = buffer.indexOf("'", ++index);
        }
        return buffer.toString();
    }

    public static String getSQL(String sql, Object[] replacements) {
        MessageFormat format = new MessageFormat(sql);
        return format.format(replacements);
    }

}
