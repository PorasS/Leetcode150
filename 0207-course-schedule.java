class Solution {
  Map < Integer, List < Integer >> adjacencyMap = null;
  public boolean canFinish(int numCourses, int[][] prerequisites) {

    adjacencyMap = new HashMap < > ();

    for (int i = 0; i < numCourses; i++) {
      adjacencyMap.put(i, new ArrayList < > ());
    }

    for (int j = 0; j < prerequisites.length; j++) {
      List < Integer > list = adjacencyMap.get(prerequisites[j][0]);
      list.add(prerequisites[j][1]);
    }

    for (int k = 0; k < numCourses; k++) {
      if (!dfs(k, new HashSet < > ())) {
        return false;
      }
    }

    return true;
  }

  public boolean dfs(int course, Set < Integer > visited) {

    if (visited.contains(course)) {
      return false;
    }

    visited.add(course);

    List < Integer > list = adjacencyMap.get(course);
    if (list.isEmpty()) {
      return true;
    }

    for (Integer c: list) {
      if (!dfs(c, visited)) {
        return false;
      }
      visited.remove(c);
    }

    //set empty list
    adjacencyMap.put(course, new ArrayList < > ());
    return true;
  }
}
