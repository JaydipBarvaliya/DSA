package com.dsa.Arrays

public class Main {
    public static void main(String[] args) {
        System.out.println(unique1("james"));
    }
      
// -------------------------------------------------------------
    static boolean unique1(String str) {
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    System.out.println("Not Unique");
                    return false;
                }
            }
        }
        return true;
    }
    
// -------------------------------------------------------------
    static boolean unique2(String str) {
    
        Map<Character, Integer> map = new HashMap(); 
        for(int i=0; i<str.length(); i++){
            int val= str.charAt(i);
            if( map.get(str.charAt(i)) == null ){
                map.put(str.charAt(i), 1);
            }else if (map.get(str.charAt(i))>=1){
                return false;
            }
        }
        return true;
    }
// -------------------------------------------------------------
    
    static boolean unique3(String str) {
    
    if (str.length() > 128) return false;
    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (char_set[val]) {
            return false;
        }
        char_set[val] = true;
    }
    return true;
}
    
}
