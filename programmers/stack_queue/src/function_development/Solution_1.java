package function_development;

import java.util.Arrays;

public class Solution_1 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            // day * speeds[i] -> 필요한 일 수가 이전보다 많으면 while문 안으로 들어감
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(result));
    }
}
