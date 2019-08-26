package com.example.demo.dao;

import java.util.HashMap;
import java.util.Map;

public class Encryption {
    //  String str;
    static Map<Character,Character> map=new HashMap<Character,Character>();
    static  Map<Character,Character>map1=new HashMap<Character,Character>();
    public Encryption(){
        String a="abcdefghijklmnopqrstuvwxyz*1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ.!@#$%^&?/";
        String b="EveQ56k#Mn2R3$WoFANh%@zXS^Kf*1/Y4OT&ZGilLj!xdBmyH7g?Ubrc9Cs.PwIquD8JVp0ta";
        for(int i=0;i<a.length();i++){
            map.put(a.charAt(i),b.charAt(i));
            map1.put(b.charAt(i),a.charAt(i));
        }
    }
    public  static String encrypt(String str){
        String s2= str.toLowerCase();
        String d = "";
        for (int i = 0; i < s2.length(); i++) {
            d = d + map.get(s2.charAt(i));
        }
        return d;
    }
    public static String decrypt(String str){
        String d = "";
        for (int i = 0; i < str.length(); i++) {
            d = d + map1.get(str.charAt(i));
        }
        return d;
    }
}

