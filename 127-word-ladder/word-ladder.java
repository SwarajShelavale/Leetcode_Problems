class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>();
        for (String word : wordList)
            dict.add(word);

        if (!dict.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int count = 1;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        char originalChar = arr[j];
                        arr[j] = k;
                        String str = new String(arr);
                        if (str.equals(endWord))
                            return count;

                        if (!str.equals(word) && dict.contains(str)) {
                            q.add(str);
                            dict.remove(str); // Mark the word as visited
                        }
                        // Restore the original character for the next iteration
                        arr[j] = originalChar;
                    }
                }
            }
        }

        return 0; // If no transformation sequence is found
    }
}
