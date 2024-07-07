class Solution {
  int[] rank = null;
  int[] vertices = null;
  public int[] findRedundantConnection(int[][] edges) {

    rank = new int[edges.length + 1];

    Arrays.fill(rank, 1);

    vertices = new int[edges.length + 1];

    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = i;
    }

    int[] res = new int[2];
    for (int j = 0; j < edges.length; j++) {
      int[] edge = edges[j];
      int par1 = parent(edge[0]);
      int par2 = parent(edge[1]);

      if (par1 == par2) {
        res[0] = edge[0];
        res[1] = edge[1];
        return res;
      }

      if (rank[par1] >= rank[par2]) {
        vertices[par2] = par1;
        rank[par1] += 1;
      } else {
        vertices[par1] = parent(par2);
        rank[par2] += 1;
      }
    }

    return res;
  }

  public int parent(int ch) {
    while (ch != vertices[ch]) {
      ch = vertices[ch];
    }
    return ch;
  }
}
