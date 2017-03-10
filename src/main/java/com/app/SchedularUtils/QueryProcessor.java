package com.app.SchedularUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by K.Kokulan on 3/2/2017.
 */
public class QueryProcessor {

    public void printX(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        System.out.println("my job : " + dateFormat.format(date));
    }
}
