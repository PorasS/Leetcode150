class Solution {
    public int leastInterval(char[] tasks, int n) {

        if(tasks.length == 1){
            return 1;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.freq - n1.freq);

        Map<Character, Integer> map = new HashMap<>();
        //count the occurrences
        for(int i = 0; i < tasks.length; i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i],0);
            }
            map.put(tasks[i], map.get(tasks[i]) + 1);
        }

        //now add the occurrences map elements to priorityQueue
        for(Map.Entry<Character, Integer> e : map.entrySet() ){
            Node node = new Node(e.getKey(), e.getValue());
            pq.offer(node);
        }

        map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        int interval = 0;
        while(!pq.isEmpty()){
            interval+=1;
            int size = pq.size();
            for(int j = 0; j < size; j++){
                Node nd = pq.poll();
                char task = nd.task;
                int freq = nd.freq;
                int nf = interval + n + 1;
                if(!map.containsKey(task) || interval >= map.get(task)){
                    nd.freq = freq - 1;
                    if(nd.freq > 0){
                        pq.offer(nd);
                        map.put(task, nf);
                    }
                    break;
                }else {
                    queue.offer(nd);
                }
            }
        
            while(!queue.isEmpty()){
                pq.offer(queue.poll());
            }
        }

        return interval;

    }

    class Node{
        char task;
        int freq;

        public Node(char task, int freq){
            this.task = task;
            this.freq = freq;
        }
    }
}
