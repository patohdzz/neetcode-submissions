class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        // use a map for frequencies of character (char, freq)
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        // use another map as a window, we will compare it to the prev map
        int l = 0;

        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        int needCount = need.size();

        //these two variables will be where the min substring starts/ends
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            // “My current window is valid, so let me keep making it smaller until it becomes invalid.”
            while (have == needCount) {
                // save endpoint variables since we want the minimum
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }

                // start removing to check if we can make this smaller
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);

                if (need.containsKey(left) && window.get(left).intValue() < need.get(left).intValue()) {
                    have--;
                }                

                l++;
            }
        }
        // now check if we actually found a minLength
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);


    }
}
