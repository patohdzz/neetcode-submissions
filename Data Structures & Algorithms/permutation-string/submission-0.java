class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            count2[s2.charAt(i) - 'a']++;

            if (i >= window) { // >= because i is 0 based index
                count2[s2.charAt(i - window) - 'a']--;
            }

            if (matches(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    boolean matches(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
