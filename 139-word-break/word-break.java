class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dictionary = new HashSet<>(wordDict);
        return findWord(0, s, dictionary, new Boolean[s.length()]);
    }

    boolean findWord(int start, String s, HashSet<String> dictionary, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (dictionary.contains(s.substring(start, end)) && findWord(end, s, dictionary, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}