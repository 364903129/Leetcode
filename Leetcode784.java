// --------------- Letter Case Permutation -----------------
/* Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. You can return the output in any order. */
// Time complexity: O(N + 2^N) where N is the total character in the String
// Space complexity: O(N + 2^N) where N is the total character in the String
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if(S == null)
            return result;
        String letter = "";
        getPermutation(result, letter, S, 0);
        return result;
    }
    
    private void getPermutation(List<String> result, String letter, String S, int startIndex){
        //if this is a vaild unique letter, add it to result
        if(startIndex == S.length()){
            result.add(new String(letter));
            return;
        }
        //if the character is a digit, skip this character by add startIndex by 1
        if(Character.isDigit(S.charAt(startIndex))){
            getPermutation(result, letter + S.charAt(startIndex), S, startIndex + 1);
            return;
        }
        //get the permutation of the lower case letter
        getPermutation(result, letter + Character.toLowerCase(S.charAt(startIndex)), S, startIndex + 1);
        //get the permutation of the upper case letter
        getPermutation(result, letter + Character.toUpperCase(S.charAt(startIndex)), S, startIndex + 1);
    }
}
