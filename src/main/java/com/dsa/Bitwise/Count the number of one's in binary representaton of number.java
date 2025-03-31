package com.dsa.Bitwise;

public class Main {
    public static void main(String[] args) {
        
        System.out.println(simpler(19));
        
    }
    static int count = 0;
    
    static int simpler(int n){
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    
    static int naive(int n){
        
        if(n == 0){
            return 0;
        }else{
            n = n & n-1;
            if(n==0){
                count++;
                return count;
            }else{
                count++;
                naive(n);
            }
        }
        return count;
    }
}
