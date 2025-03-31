package com.dsa.LCS;

class Solution{
  
    public static int shortestCommonSupersequence(String X, String Y, int m, int n){

        int lcs = LCS(X.toCharArray(), Y.toCharArray(), m, n );
        return X.length() + Y.length() - lcs; 
        
    }

    static int LCS(char[] X, char[] Y, int m, int n ){
      
        int matrix[][] = new int[ m+1 ][ n+1 ];
    
        for(int i=1; i<m+1; i++){
            
            for(int j=1; j<n+1; j++){
                
                if (X[i-1] == Y[j-1]){
            	    matrix[i][j] =  1 + matrix[i-1][j-1];  
            	}else {
            	    matrix[i][j] =  Math.max( matrix[i][j-1], matrix[i-1][j] );
            	}
            }
        }
    	return matrix[m][n];
      }
    }
