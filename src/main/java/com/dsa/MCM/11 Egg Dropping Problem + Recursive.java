package com.dsa.MCM;//Question tell us to assume tthe worst case here and as we know that the worst case always comes with the maximum number or possibilities or attempts or choices.
//With considering that facts we move forward with the MAX between break or not break


// It is very important to understand why we are sending (f-k) in case of egg didn't break and again using a for loop where k is initiated from 1 again.
// the reason is we are checking for a range where we are min number of possibly attempt where egg didn't break.
// Let's say in simple terms there are 10 floor.
// Egg didn't break from 7th floor. So now only 10-7 = 3 floor needs to be checked.
// But to check the next 3 floor we need to use a k loop again.
// Here k=1 will represent 8th floor.
// Here k=2  will represent 9th floor.
// Here k=3  will represent 10th floor.

// So to answer the initial question, You need to check the min number of attempts in next 3 floors and that is why you are sending (f-k) and k range is (1,f-k)
// PS. I was not able to understand for 2 days why we are looping from K=1 again. Putting this explanation out incase someone gets stuck in the same point again.



// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Why are we using max, i.e how are we understanding the worst the case in this?

// we have to find the minimum number of attempt to find the critical floor,
// we don't know which floor would be the most optimal floor to make the first attempt hence we are trying out all the floors through the loop,
// also we do not know if dropping from a certain floor will cause the egg to break or not
// so we are testing for both cases one in which we assume that the egg would break and in the other we assume that it won't,
// recursive calls with left over eggs and floors in both cases give us the number of attempts required.
// But since the question asks us to assume the worst case we take the possibility as a fact which requires greater number of attempts to find the critical floor. 

// In simpler terms, suppose if we are testing for the 3rd floor then we check the number of attempts to find the critical floor
// for both cases if the egg would break from the 3rd floor and if the egg wont break from the 3rd floor,
// if it requires greater number of attempts to find the critical floor if the egg would break if dropped form the 3rd floor
// then we would assume that upon dropping from the 3rd floor the egg would actually break because we want the worst case here.
// Then we take the minimum of number of attempts required for finding the critical floor in worst case of all of the floors in our range and that is the answer.




// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// For those who did not get the max and min usage here : 
// Consider there are 10 floors in total and we got some x eggs to test . 
// Lets say we are at 8th floor now(Problem would start from the 1st floor but consider that we are at 8th) . Here we have two options  .
// 1. Egg breaks (we are left with x-1 eggs and 7 floors (8th floor is not the critical one so go down by 1 floor)  
// 2. Egg does'nt break ( we are left with x eggs and 2 floors(9,10 to test)  as 8th floor did not break , its waste of time to go down and check other floors as the problem states if the egg doesnt break at one floor it doesnt break on the floors below to it as well ))

// Now here comes the critical point to note , floors to test now are
// 1. 1-7  so total of 7 floors(egg broke)
// 2. 9-10 so total of 2 floors (egg did not break) 

// Whom do you think will give the us the answer  Max(attempts (7 floors), (2 floors))) , obviously 7 will yeild more floors to test (Keep in mind , you have to cover all the floors so go by max).
// So that is the reason why we use max(floorsRemainingEggBrokenCase, floorsRemainingEggunbrokenCase)

// And finally here comes the min part : 
// Now we tested this by dropping the egg at 8th floor , similarly 3rd floor will yeild us an answer , similarly 5th floor will yeild a diff ans and so on ... till n floors 
// Tats y we return the min(egg drop attempts on all the floors)!

class Solution {
    
    static int eggDrop(int e, int f){
        
        if(e==0 || f==0 || e==1) return f;
        
        int min = Integer.MAX_VALUE;
        
        for(int k=1; k<=f; k++){
            
            int tempAns = 1 + Math.max(eggDrop(e-1, k-1), eggDrop(e, f-k));
            min = Math.min(min, tempAns);
        }
        return min;
	}
}


//Time Complexity :  Since we have to loop n times . 
//                   And for each n times we are calling 2 recursive fun so 2^n
//                   hence n*2^n