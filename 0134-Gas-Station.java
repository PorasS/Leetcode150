class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {


        int stIdx = 0;
        int idx = 0;
        int tank = -1;

        //Set<Integer> visited = new HashSet<>();

        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0; i < gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        // while(true){
        //     if(stIdx == idx && tank != -1){
        //         return idx;
        //     }

        //     if(visited.contains(stIdx) && tank == -1){
        //         return -1;
        //     }

        //     //gas =  [2,3,4]
        //     //cost = [3,4,3]
        //     //        0 1 2
        //     //stIdx = 2
        //     //idx = 2
        //     //vis : 0, 1, 2, 0
        //     visited.add(stIdx);
        //     tank = tank == -1 ? 0 + gas[idx] : tank + gas[idx]; //4

        //     if(tank - cost[idx] < 0){//4-3 = -1
        //         stIdx = (stIdx+1) % gas.length;
        //         idx = stIdx;
        //         tank = -1;
        //     }else{
        //         tank = tank - cost[idx]; //
        //         idx = (idx+1) % gas.length;
        //     }
        // }

        // return -1;

        int start = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                start = i+1;
            }
        }

        return start;
    }
}
