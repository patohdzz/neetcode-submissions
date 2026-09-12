class TimeMap {
    // key, values with their respective times
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // if key is new put a new key
        map.putIfAbsent(key, new ArrayList<>());
        // get the key and add a new pairing to it
        map.get(key).add(new Pair(timestamp, value));   
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        // get the list of pairs from key
       List<Pair> curList = map.get(key);
       int left = 0;
       int right = curList.size() - 1;
       String result = "";

       while (left <= right) {
            int mid = (left + right) / 2;
            // if pair at mid has a time <= timestamp get it, however there can be a better one
            if (curList.get(mid).time <= timestamp) {
                result = curList.get(mid).value;
                left = mid + 1;

            } else {
                right = mid - 1;
            }
       }

        return result;
    }

    // inner class to create the pairing of values with their times
    static class Pair {
        int time;
        String value;
        Pair(int timestamp, String val) {
            time = timestamp;
            value = val;
        }
    }

}


