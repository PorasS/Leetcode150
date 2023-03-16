class TimeMap {
    
    Map<String, List<Node>> timeMap = null;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<>());
        }
        List list = timeMap.get(key);
        Node node = new Node(value, timestamp);
        list.add(node);
        timeMap.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List list = timeMap.get(key);

        String res = "";
        if(list!=null){
            int l = 0;
            int r = list.size()-1;
            while(l<=r){
                int mid = (l+r)/2;

                Node node = (Node) list.get(mid);
                if(timestamp >= node.timestamp){
                    res = node.value;
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return res;

    }

    class Node{
        String value;
        int timestamp;

        Node(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
