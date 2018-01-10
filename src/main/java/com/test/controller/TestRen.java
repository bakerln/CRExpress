package com.test.controller;

import java.util.Scanner;

public class TestRen {

    public static void main(String[] args) {
        Scanner scanner=new Scanner (System.in);
           System.out.println("请输入数字");
        double i=scanner.nextDouble();
        if(i<10)
            System.out.println(i + "小于10");
      else if(i>10)
          System.out.println(i + " 大于10");
      else
          System.out.println(i +"等于10");
      //判断语句  if else
    }


}
