import java.util.*;

class Twitter {
    private static int timeStamp = 0;

    // user -> set of followees
    private Map<Integer, Set<Integer>> followMap;
    // user -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    private class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // post a tweet
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    // get 10 most recent tweets
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // add user's own tweets
        if (tweetMap.containsKey(userId)) {
            maxHeap.addAll(tweetMap.get(userId));
        }

        // add followees' tweets
        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                if (tweetMap.containsKey(followee)) {
                    maxHeap.addAll(tweetMap.get(followee));
                }
            }
        }

        // get top 10
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().id);
            count++;
        }
        return result;
    }

    // follow
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    // unfollow
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
