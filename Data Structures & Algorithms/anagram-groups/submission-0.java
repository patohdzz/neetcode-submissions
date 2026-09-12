class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // this count will be our key for detecting anagrams
            String key = Arrays.toString(count);
            // does nothing if key is already in the map
            map.putIfAbsent(key, new ArrayList<>());
            // adds the current string to the values of the current key
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
