package com.dsa.MCM;

class Solution {
    
    int isScramble(final String A, final String B) {
        return fun(A,B)?1:0;
    }

    boolean fun(String a, String b){

        if(a.equals(b)) return true;
        if(a.length()<=1)   return false;

        boolean flag=false;

        for(int k=1; k<=a.length()-1 ;k++){
            if( fun(a.substring(0,k),b.substring(a.length()-k))==true && fun(a.substring(k),b.substring(0, a.length()-k))==true){
                flag=true;
                break;
            }else if(fun(a.substring(0,k),b.substring(0,k))==true &&   fun(a.substring(k),b.substring( k))==true) {
                flag=true;
                break;
            }    
        }
        return flag;
    }
}
