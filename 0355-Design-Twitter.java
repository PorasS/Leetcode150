//Fanout-on-write solution
//create the timeline when the user adds a post
class Twitter {

    //Requirement:
    //1. user will create a tweet
    //2. tweet should be available in user's followers timeline
    //3. 

    //followers
    Map<Integer, Set<Integer>> followers;
    Map<Integer, Set<Integer>> following;
    int timestamp;
    Map<Integer, PriorityQueue<Tweet>> timeline;
    Map<Integer, List<Tweet>> tweetsMap;
    
    public Twitter() {
        followers = new HashMap<>();
        timestamp = 0;
        timeline = new HashMap<>();
        following = new HashMap<>();
        tweetsMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(userId, tweetId, ++timestamp);

        // 1 -> [{tweet:1},{tweet:2}]
        if(!tweetsMap.containsKey(userId)){
            tweetsMap.put(userId, new ArrayList<>());
        }

        List<Tweet> tweetList = tweetsMap.get(userId);
        tweetList.add(t);

        if(!followers.containsKey(userId)){
            Set<Integer> followee = new HashSet<>();
            followee.add(userId);
            followers.put(userId, followee);
        }

        Set<Integer> follows = followers.get(userId);

        for(Integer follower : follows){
            if(!timeline.containsKey(follower)){
                timeline.put(follower, new PriorityQueue<>((t1, t2) -> t2.timestamp - t1.timestamp));
            }

            PriorityQueue<Tweet> pq = timeline.get(follower);
            pq.offer(t);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!timeline.containsKey(userId)){
            return new ArrayList<>();
        }

        List<Tweet> tweetList = new ArrayList<>();
        PriorityQueue<Tweet> tweets = timeline.get(userId);

        List<Tweet> resTweets = new ArrayList<>();
         for(Tweet t : tweets){
            resTweets.add(t);
        }

        resTweets.sort((t1, t2) -> t2.timestamp - t1.timestamp);
        List<Integer> res = new ArrayList<>();
        for(Tweet t : resTweets){
            res.add(t.tweetId);
            if(res.size() > 9){
                break;
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followeeId)){
            followers.put(followeeId, new HashSet<>());
        }

        Set<Integer> follows = followers.get(followeeId);
        if(follows.contains(followerId)){
            return;
        }

        follows.add(followerId);
        follows.add(followeeId);

        if(!following.containsKey(followerId)){
            following.put(followerId, new HashSet<>());
        }

        Set<Integer> s = following.get(followerId); 
        s.add(followeeId);
        s.add(followerId);

        if(tweetsMap.get(followeeId) == null){
            return;
        }

        PriorityQueue<Tweet> pq = timeline.get(followerId);
        if(pq == null){
            timeline.put(followerId, new PriorityQueue<>((t1, t2) -> t2.timestamp - t1.timestamp));
        }

        pq = timeline.get(followerId);

        for(Tweet t : tweetsMap.get(followeeId)){
            pq.add(t);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followeeId)){
            Set<Integer> follows = followers.get(followeeId);
            follows.remove(followerId);
        }

        if(following.containsKey(followerId)){
            Set<Integer> f = following.get(followerId);
            f.remove(followeeId);
        }

        PriorityQueue<Tweet> pq = timeline.get(followerId);
        PriorityQueue<Tweet> newPq = new PriorityQueue<>((t1, t2) -> t2.timestamp - t1.timestamp);
        while(!pq.isEmpty()){
            Tweet t = pq.poll();
            if(t.userId != followeeId){
                newPq.offer(t);
            }
        }

        timeline.put(followerId, newPq);
    }
}

class Tweet{
    int userId;
    int tweetId;
    int timestamp;

    public Tweet(int userId, int tweetId, int timestamp){
        this.userId = userId;
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }

    public String toString(){
        return "["+userId+","+tweetId+","+timestamp+"]";
    }
}


//tweets = Map<userId, maxHeap<Followers Tweet>>
//follow = Map<followerId, <FolloweedId>>
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
-------------------------------------
class Twitter {

  class Tweet {
    int userId;
    int tweetId;
    long timeStamp;

    Tweet(int userId, int tweetId, long timeStamp) {
      this.userId = userId;
      this.tweetId = tweetId;
      this.timeStamp = timeStamp;
    }
  }

  class User {
    int userId;
    List < Integer > follows;

    User(int userId) {
      this.userId = userId;
      follows = new ArrayList < > ();
    }

    public void addFollow(int follow) {
      if (!follows.contains(follow)) {
        follows.add(follow);
      }
    }

    public void removeFollow(int followId) {
      follows = follows.stream().filter(id -> id != followId).collect(Collectors.toList());
    }
  }

  //UserTable will store the details of user
  //and the list of followed users
  Map < Integer, User > userTable;

  //tweetTable will store the 
  //User's Tweets and the created time stamp
  Map < Integer, List < Tweet >> tweetTable;
  int counter;
  public Twitter() {
    userTable = new HashMap < > ();
    tweetTable = new HashMap < > ();
    counter = 0;
  }

  public void postTweet(int userId, int tweetId) {
    User user = null;
    if (userTable.containsKey(userId)) {
      user = userTable.get(userId);
    } else {
      user = new User(userId);
      user.addFollow(userId);
      userTable.put(userId, user);
    }

    if (!tweetTable.containsKey(userId)) {
      tweetTable.put(userId, new ArrayList < > ());
    }

    List < Tweet > tweets = tweetTable.get(userId);
    Tweet t = new Tweet(userId, tweetId, System.currentTimeMillis() + (++counter));
    tweets.add(t);
  }

  public List < Integer > getNewsFeed(int userId) {
    User user = userTable.get(userId);
    if (user != null) {
      List < Integer > follows = user.follows;

      // sorted in descending orderBY timestamp
      PriorityQueue < Tweet > pq = new PriorityQueue < > ((t1, t2) -> Long.compare(t2.timeStamp, t1.timeStamp));

      for (int followedId: follows) {
        List < Tweet > tweets = tweetTable.get(followedId) == null ? new ArrayList < > () : tweetTable.get(followedId);
        for (Tweet t: tweets) {
          pq.offer(t);
        }
      }

      List < Integer > res = new ArrayList < > ();

      int count = 10;

      while (!pq.isEmpty() && count > 0) {
        Tweet tw = pq.poll();
        res.add(tw.tweetId);
        count--;
      }

      return res;
    }

    return new ArrayList < > ();
  }

  //followerId is following followedId
  public void follow(int followerId, int followeeId) {
    //get the list of followers for followeeId
    //add the new entry in the list
    User user = userTable.get(followerId);
    if (user == null) {
      user = new User(followerId);
      user.addFollow(followerId);
      userTable.put(followerId, user);
    }
    user.addFollow(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    User user = userTable.get(followerId);
    user.removeFollow(followeeId);
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
