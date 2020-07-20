package com.hdw.timenew;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hdw
 * @create 2020-06-23-10:48
 * @desc 描述
 */
public class TestThreadLocal {

  public static final ThreadLocal<DateFormat> tl=new ThreadLocal <DateFormat>(){
      @Override
      protected DateFormat initialValue() {
          return new SimpleDateFormat("yyyyMMdd");
      }
  };

  public static Date convert(String value) throws Exception {
     return  tl.get().parse(value);
  }
}
