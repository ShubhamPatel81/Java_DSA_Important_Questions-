package Top_Interview_150_leetcode;

//There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
//
//        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
//
//        Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
//
//
//
//        Example 1:
//
//        Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//        Output: 3
//        Explanation:
//        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//        Travel to station 4. Your tank = 4 - 1 + 5 = 8
//        Travel to station 0. Your tank = 8 - 2 + 1 = 7
//        Travel to station 1. Your tank = 7 - 3 + 2 = 6
//        Travel to station 2. Your tank = 6 - 4 + 3 = 5
//        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//        Therefore, return 3 as the starting index.
public class Gas_Station_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int fuel = 0;
        int n = gas.length;
        int total = 0;
        for(int i = 0; i< n; i++){
            int diff = gas[i] - cost[i];
            total += diff;
            fuel += diff;
            if(fuel <0 ){
                index = i+1;
                fuel = 0;
            }
        }
        return (total<0)? -1:index;
    }

    public static void main(String[] args) {
        Gas_Station_134 g = new Gas_Station_134();
        int gas[] = {1,2,3,4,5} ;
        int[]cost = {3,4,5,1,2};
        int ans = g.canCompleteCircuit(gas,cost);
        System.out.println("The Final Destination is : "+ans);
    }
}
