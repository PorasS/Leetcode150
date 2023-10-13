class Solution {
  Map < Integer, List < Integer >> adjMap = null;
  List < Integer > res = new ArrayList < > ();
  Set < Integer > visited = new HashSet < > ();
  Set < Integer > cycle = new HashSet < > ();
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    if (prerequisites.length == 0) {
      int[] array = new int[numCourses];
      int idx = 0;
      for (int i = numCourses - 1; i >= 0; i--) {
        array[idx++] = i;
      }

      return array;
    }

    adjMap = new HashMap < > ();

    for (int i = 0; i < numCourses; i++) {
      adjMap.put(i, new ArrayList < > ());
    }

    for (int j = 0; j < prerequisites.length; j++) {
      List nodes = adjMap.get(prerequisites[j][0]);
      nodes.add(prerequisites[j][1]);
    }

    //each course
    for (int c = 0; c < numCourses; c++) {
      dfs(c);
    }

    int idx = 0;
    int[] resArray = new int[res.size()];

    if (res.size() != numCourses) {
      //All courses are not finished
      return new int[0];
    }

    for (int l = 0; l < res.size(); l++) {
      resArray[idx++] = res.get(l);
    }
    return resArray;
  }

  public boolean dfs(int course) {

    if (cycle.contains(course)) {
      res = new ArrayList < > ();
      return false;
    }

    if (visited.contains(course)) {
      return true;
    }

    visited.add(course);
    cycle.add(course);
    List < Integer > adjList = adjMap.get(course);
    for (Integer c: adjList) {
      if (!dfs(c)) {
        return false;
      }
    }

    //no cycle found for the course
    cycle.remove(course);
    res.add(course);
    return true;
  }

}
