class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.occur - n1.occur);//task are picked from the heap
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        // System.out.println(map);

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            Node n1 = new Node(e.getKey(), 0, e.getValue());
            pq.offer(n1);
        }

        Queue<Node> q = new LinkedList<>();// waiting queue
        int minInterval = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            minInterval+=1;
            
            Node task = null;
            if(!pq.isEmpty()){
                task = pq.poll();
                task.occur-=1;
                task.time = minInterval + n;

                if(task.occur > 0){
                    q.offer(task);
                }
            }

            if(!q.isEmpty()){
                task = q.peek();

                if(task.time == minInterval){
                    pq.offer(q.poll());
                }
            }
        }

        return minInterval;
    }
}


class Node{
    char c;
    int time;
    int occur;

    public Node(char c, int time, int occur){
        this.c = c;
        this.time = time;
        this.occur = occur;
    }
}
