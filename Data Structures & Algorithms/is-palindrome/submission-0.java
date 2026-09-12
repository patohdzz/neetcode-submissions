class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            // Skip non-alphanumeric on the left
            while (left < right && !valid(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric on the right
            while (left < right && !valid(s.charAt(right))) {
                right--;
            }

            // Compare characters
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean valid(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= '0' && c <= '9');
    }
}

