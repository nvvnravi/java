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
public class patperf1 {

    public static void main(String[] args) throws Exception {
        String[] params=new String[]{"from1@gdit.com","from2@gdit.com","from3@gdit.com","to@gdit.com","fromDate","todate"};
         if(params.length >= 5){
            final String START=" '%";
            final String END="%' ";
            final String sqlPart=" hmail.dbo.hm_message_metadata.metadata_from LIKE ";
            final String or=" OR ";
      String  sql = "select max(hmail.dbo.hm_message_metadata.metadata_dateutc) as request_date from hmail.dbo.hm_message_metadata  where ( {0} ) and hmail.dbo.hm_message_metadata.metadata_to LIKE ''%{1}%''  and hmail.dbo.hm_message_metadata.metadata_dateutc between CONVERT(Datetime, ''{2}'', 120) and CONVERT(Datetime, ''{3}'', 120)";
        String[] updatedParams=new String[4];
        updatedParams[3]=params[params.length-1];
        updatedParams[2]=params[params.length-2];
        updatedParams[1]=params[params.length-3];
        
        params[0] = sqlPart+START+patperf1.checkSingleQuote(params[0])+END;
        updatedParams[0]=params[0];
        for( int i = 1; i < params.length - 3; i++)
            {
                params[i]=or+sqlPart+START+patperf1.checkSingleQuote(params[i])+END;
                updatedParams[0]=updatedParams[0]+ params[i];
            }
      
        
         sql = patperf1.getSQL(sql, updatedParams);
         
          System.out.println(" final sql:"+sql  );
        }
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
