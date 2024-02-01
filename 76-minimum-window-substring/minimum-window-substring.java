import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        int targetLength = t.length();
        int sLength = s.length();

        // Constructing the targetMap to count characters in string t
        for (int i = 0; i < targetLength; i++) {
            char ch = t.charAt(i);
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int requiredChars = targetMap.size();
        int left = 0, right = 0;
        int currentChars = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (right < sLength) {
            // Expand the window by adding the right character
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // Check if the added character contributes to the required characters
            if (targetMap.containsKey(rightChar) && windowMap.get(rightChar).equals(targetMap.get(rightChar))) {
                currentChars++;
            }

            // Contract the window
            while (currentChars == requiredChars) {
                // Update the minimum length and record the start and end indices
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                    end = right;
                }

                // Move the left pointer to contract the window
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // Check if the removed character affects the required characters
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    currentChars--;
                }

                left++; // Move the left pointer to the right
            }

            right++; // Move the right pointer to the right
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
    }
}
