package com.prodius;

public class Main4 {
    public static void main(String[] args) {
//Ex.1
        String line = "Hello World!";
        char first = line.charAt(0);
        System.out.println(first);
        int l = line.length()-1;
        char last = line.charAt(l);
        System.out.println(last);

        System.out.println();
//Ex.2
        line = "Java Exercises";
        boolean b1 = line.endsWith("se");
        System.out.println("String " + line + " ends with 'se'?  " + b1);

        line = "Java Exercise";
        boolean b2 = line.endsWith("se");
        System.out.println("String " + line + " ends with 'se'?  " + b2);

        System.out.println();
//Ex.3
        String string = "Stephen Edwin King";
        String substring = "Walter Winchell";
        String substring2 = "Edwin";
        System.out.println(string.contains(substring));
        System.out.println(string.contains(substring2));

        System.out.println();
//Ex.4
        String str = "Stephen Edwin King";
        System.out.println("Walter Winchell".equalsIgnoreCase(str));
        System.out.println("stephen edwin king".equalsIgnoreCase(str));

        System.out.println();
//Ex.5
        String str1 = new String("Red is favorite color");
        System.out.println(str1.startsWith("Red") );

        String str2 = new String("Orange is also my favorite color");
        System.out.println(str2.startsWith("Red") );
    }
}

