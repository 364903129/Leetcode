// Letter Combinations of a Phone Number - DFS
class Solution {
    HashMap<String,String> number = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    
    List<String> result = new ArrayList<String>();
    
    public void DFS(String combinations, String next_digits){
        //1. if we out of digits, save the combinations to the result;
        if(next_digits.length() == 0){
            result.add(combinations);
            return;
        }
        //2. retrive the first digit from the digits, then retrive the letter using the digit.
        String digit = next_digits.substring(0,1);
        String letter = number.get(digit);
        
        //3. recursively doing DFS
        for(int i = 0; i < letter.length(); i++){
            DFS(combinations + letter.substring(i, i+1), next_digits.substring(1));
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0)
            DFS("", digits);           
        return result; 
    }
}
