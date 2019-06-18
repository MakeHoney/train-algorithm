package kth_number;

import java.util.Arrays;

public class Solution_1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for (int[] command : commands) {
            int[] subList = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subList);
            answer[idx++] = subList[command[2] - 1];
        }

        return answer;
    }
}
