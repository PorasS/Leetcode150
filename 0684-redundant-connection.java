class Solution {

  List < List < Integer >> resList = null;
  int[] nodes = null;
  int[] sz = null;
  public int[] findRedundantConnection(int[][] edges) {
    //Weighted union find
    nodes = new int[edges.length + 1];
    sz = new int[edges.length + 1];

    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = i;
      sz[i] = 1;
    }

    //nodes[1,2,3,4,5]
    resList = new ArrayList < > ();

    for (int j = 0; j < edges.length; j++) {
      union(edges[j][0], edges[j][1]);
    }

    int[] res = new int[2];

    if (!resList.isEmpty()) {
      List < Integer > redudantEdge = resList.get(resList.size() - 1);
      res[0] = redudantEdge.get(0);
      res[1] = redudantEdge.get(1);
    }

    return res;
  }

  public void union(int p, int q) {
    int pRoot = getRoot(p);
    int qRoot = getRoot(q);

    //p and q are connected, if we add an edge between p and q , will create a cycle
    if (pRoot == qRoot) {
      List < Integer > list = new ArrayList < > ();
      list.add(p);
      list.add(q);
      resList.add(list);
    }

    if (sz[pRoot] >= sz[qRoot]) {
      nodes[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    } else {
      nodes[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    }
  }

  public int getRoot(int node) {
    while (nodes[node] != node) {
      node = nodes[node];
    }
    return node;
  }

}
