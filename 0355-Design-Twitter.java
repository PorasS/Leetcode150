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
