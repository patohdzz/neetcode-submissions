class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    // 4#star3#ate

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int index = 0;
        while (index < str.length()) {
            // have another index check the beginning number up to the delimeter
            int j = index;
            while(str.charAt(j) != '#') {
                j++;
            }
            int size = Integer.parseInt(str.substring(index, j));
            index = j + 1;
            j = index + size;
            res.add(str.substring(index, j));
            index = j;
        }
        return res;
    }
}
