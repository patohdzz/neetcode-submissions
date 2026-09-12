class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            // map contains (character, frequency)
            m1.put(c, m1.getOrDefault(c, 0) + 1);
            m2.put(c2, m2.getOrDefault(c2, 0) + 1);
        }

        return m1.equals(m2);
    }
}
