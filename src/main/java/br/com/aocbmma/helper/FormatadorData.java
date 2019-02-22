package br.com.aocbmma.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatadorData{

    public static Date getDataFormatadaNoPadraoSQL(String dataString){
        Date data = null;
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            data = formato.parse(dataString);
        }catch(ParseException e){
            e.printStackTrace();
        }
        
        return data;
    }


}