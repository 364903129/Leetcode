// one direction BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for(String word: wordList){
            wordSet.add(word);
        }
        int len = beginWord.length(), number = 1;
        Queue<Pair<String, Integer>> wordQueue = new LinkedList<>();
        wordQueue.offer(new Pair(beginWord, number));
        Map<String, Boolean> used = new HashMap<>();
        used.put(beginWord,true);
        while(!wordQueue.isEmpty()){
            Pair<String, Integer> wordPair = wordQueue.poll();
            if(wordPair.getKey().equals(endWord)) return wordPair.getValue();
            number = wordPair.getValue() + 1;
            for(int i = 0; i < len; i++){
                char[] word = wordPair.getKey().toCharArray();
                for(char j = 'a'; j <= 'z'; j++){
                    word[i] = j;
                    String words = new String(word);
                    if(wordSet.contains(words) && !used.containsKey(words)){
                        wordQueue.offer(new Pair(words, number));
                        used.put(words, true);
                        wordSet.remove(words);
                    }
                }
            }
        }
        return 0;
    }
}
