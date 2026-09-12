class Twitter {
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> follows;
    private int count;

    public Twitter() {
        count = 0;
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // if key exists, it acts like a .get() which you can then call .add()
        // if it doesnt, it puts a new value into map and return you that value so you can call .add()
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();        
        // make sure user follows themselves
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        Set<Integer> followees = follows.get(userId);
        // min-heap by timestamp (smaller count == more recent tweet)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // heap setup = {timestamp, tweetId, followeeId, indexInList}
        
        // for every followee who has at least one tweet, put their most recent tweet 
        // (last element of their list) into the heap.
        for (int followerId : followees) {
            List<int[]> followerTweets = tweets.get(followerId);
            if (followerTweets != null && !followerTweets.isEmpty()) {
                int[] recentTweet = followerTweets.get(followerTweets.size() - 1);
                minHeap.offer(new int[] {recentTweet[0], recentTweet[1], followerId, followerTweets.size() - 1});
            }
        }

        // Repeat 10 times (or until heap is empty): poll the heap's top (the most-recent tweet across all current  candidates). Record its tweetId. Then check: does that same user have an earlier tweet (the one right before the one you just popped, in their list)? If so, push that one into the heap as the new candidate from that user.
        while(!minHeap.isEmpty() && result.size() < 10) {
            int[] top = minHeap.poll();
            int timestamp = top[0], tweetId = top[1], followeeId = top[2], index = top[3];
            result.add(tweetId);
            // does this user have an earlier tweet? if so push it as the next candidate
            if (index > 0) {
                List<int[]> remainingTweets = tweets.get(followeeId);
                int[] nextTweet = remainingTweets.get(index - 1);
                minHeap.offer(new int[] {nextTweet[0], nextTweet[1], followeeId, index - 1});
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);            
        }
    }
}
