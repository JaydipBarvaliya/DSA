package com.dsa.Sliding

class Solution {
    public String minWindow(String str, String t) {
        
		
		HashMap<Character,Integer> map = new HashMap<>();
        
        //population t into map
		for(int k=0 ; k<t.length(); k++) 
            map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) + 1);
		        

		int count = map.size();

		//this Integer.MAX_VALUE is most important, just try to put 0 and this program will not run..think twice
		int minWinSize = Integer.MAX_VALUE;
		String ans = "";

		int i=0;
        int j=0;
        int n=str.length();

		while( j<n) {
            
			char rightChar = str.charAt(j);
            
			if(map.containsKey(rightChar)) {
			
                map.put(rightChar, map.get(rightChar) - 1 );
                
				if(map.get(rightChar) == 0){
					count--; 
				}			
			}
            
            
			if(count == 0 ) {
                
				//calculate ans
                
                int currWinSize = j-i+1; 
                
                if(currWinSize < minWinSize) {
					ans = str.substring(i,j+1);
					minWinSize = currWinSize;
				}
                
                //reducing the window from left till we are stick with our answer count=0
				while(count == 0 && i<=j) {
                    
					char leftChar = str.charAt(i);
                    
					if(map.containsKey(leftChar)) {
                        
						if(map.get(leftChar)==0) {
							count++;
						}
						map.put(leftChar, map.get(leftChar)+1);
					}
                    
					i++;
                    
                    //After Reducing every character we are again checking remaining
                    //window that is it eligible for potential candidate or not
                    
					if(count == 0 && j-i+1 < minWinSize) {
						ans = str.substring(i,j+1);
						minWinSize = j-i+1;
					}
				}
			}
            j++;
		}
        
		return ans;
    }
}