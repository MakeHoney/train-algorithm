package truck_passing_bridge;

import java.util.LinkedList;

public class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 1, idx = 0, weightOnBridge = 0;
        LinkedList<Integer> bridgeQueue = new LinkedList<>();

        for (int i = 0; i < bridgeLength - 1; i++) bridgeQueue.add(0);

        bridgeQueue.add(truckWeights[idx]);
        weightOnBridge += truckWeights[idx++];

        while(weightOnBridge > 0) {
            // 다리에 놓인 엘레먼트들의 합이 0 이상이어야한다. -> 하나의 트럭이상 다리 위에 있어야한다.
            // 큐의 길이가 다리의 길이 이상이어야 한다. -> 큐의 길이가 다리길이보다 커지면 디큐 연산
            if (bridgeQueue.size() >= bridgeLength && bridgeQueue.stream().mapToInt(Number::intValue).sum() > 0) {
                int dequeOne = bridgeQueue.remove();
                if (dequeOne > 0) weightOnBridge -= dequeOne;

                if (idx != truckWeights.length) {
                    // 새로 들어오는 트럭과 다리위 트럭들의 무게의 합이 한도 이하여야한다.
                    if (weightOnBridge + truckWeights[idx] <= weight && bridgeQueue.size() < bridgeLength) {
                        weightOnBridge += truckWeights[idx];
                        bridgeQueue.add(truckWeights[idx++]);
                    } else if (bridgeQueue.size() < bridgeLength) {
                        bridgeQueue.add(0);
                    }
                // 모든 트럭이 트럭배열에서 빠졌으면 다리 큐에 0을 넣는다.
                } else if (bridgeQueue.size() < bridgeLength) {
                    bridgeQueue.add(0);
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int result = sol.solution(100, 100, new int[]{10});
        int result = sol.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(result);
    }
}
