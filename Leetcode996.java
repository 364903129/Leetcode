// ------------- Number of Squareful Arrays----------------
/* Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i]. */
//Time complexity: O(N! * N) where N is the length of the array.
//Space complexity: O(N) where N is the length of the array.

class Solution {
    
    private int count = 0;
    
    public int numSquarefulPerms(int[] A) {
        //base case: if A has no number, return 0
        if(A.length == 0 || A == null)
            return 0;
        
        List<Integer> combination = new ArrayList<>();
        boolean[] used = new boolean[A.length];
        Arrays.sort(A);
        helper(combination, A, used);
        return count;
    }
    
    private void helper(List<Integer> combination, int[] A, boolean[] used){
        //if this combination is a vaild Squareful Arrays, increase the count by 1
        if(combination.size() == A.length){
            count++;
            return;
        }
        for(int k = 0; k < A.length; k++){
            //avoid use the same element more than once
            if(used[k]) continue;
            //avoid duplicate number
            if(k > 0 && A[k] == A[k-1] && !used[k-1]) continue;
            //if the sum of two numbers is not perfect square, skip this invaild combination to save the run time.
            if(combination.size() > 0 && !squareFul(A[k] + combination.get(combination.size()-1))) continue;
            combination.add(A[k]);
            used[k] = true;
            helper(combination, A, used);
            combination.remove(combination.size() - 1);
            used[k] = false;
        }
    }
    
    private boolean squareFul(int number){
        double sq = Math.sqrt(number);
        return ((sq - Math.floor(sq)) == 0);
    }
}
