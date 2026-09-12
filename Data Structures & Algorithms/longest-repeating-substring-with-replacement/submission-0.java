class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int max = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            int r = s.charAt(right) - 'A';
            count[r]++;
            // maxFreq will tell us how many chars in window would need to be replaced
            maxFreq = Math.max(maxFreq, count[r]);

            // check if the current window with the changes already made is 
            // greater than the allowed changes
            while ((right - left + 1) - maxFreq > k) {
                // if it is, move left pointer
                count[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
