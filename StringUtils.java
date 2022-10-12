package com.orm.project.Threads;

import java.util.HashMap;

public class StringUtils {
    public static void removeCommonChars(String str1, String str2){
        System.out.println(removeFromFirst(str1,str2)+" "+removeFromFirst(str2,str1));
    }

    //removes characters from first string that are present in second
    //solved using hashmap for better performance
    public static String removeFromFirst(String str1, String str2){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        StringBuffer output = new StringBuffer();

        for (char ch: str2.toCharArray()) {
            hashMap.put(ch,1);
        }

        for (char ch: str1.toCharArray()) {
            if (hashMap.get(ch) == null)
                output.append(ch);
        }

        return output.toString().isEmpty() ? null : output.toString();
    }

    public static void main(String[] args) {
        removeCommonChars("ABC","BC");
        removeCommonChars("BC","BANGLORE");
    }
}
