package com.dsa.LCS;

class Solution{
	public int minOperations(String str1, String str2){ 
	    
	    int len1 = str1.length();
	    int len2 = str2.length();
	    
	    int lcs = LCS(str1.toCharArray(), str2.toCharArray(), len1, len2);
    
//       int insertions = len1 - lcs; 
//       int  deletions = len2 - lcs;
//		          total = len1 - lcs + len2 - lcs	
//		          total = len1 + len2 - 2*lcs  
    
        return len1 + len2 - 2*lcs;
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
