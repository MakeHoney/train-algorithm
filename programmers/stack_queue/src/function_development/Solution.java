package function_development;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int maxPivot = 0;
        int progLength = progresses.length;
        HashMap<Integer, Integer> deployPerDay = new HashMap<>();

        for (int i = 0; i < progLength; i++) {
            int restProgress = 100 - progresses[i];
            int remainder = restProgress % speeds[i];
            int restDay = remainder == 0
                    ? restProgress / speeds[i]
                    : (restProgress / speeds[i]) + 1;

            if (i == 0) maxPivot = restDay;

            if (restDay > maxPivot) {
                answer.add(deployPerDay.get(maxPivot));
                deployPerDay.putIfAbsent(restDay, 1);
                maxPivot = restDay;
            } else {
                restDay = maxPivot;
                deployPerDay.computeIfPresent(restDay, (k, v) -> ++v);
                deployPerDay.putIfAbsent(restDay, 1);
            }

            if (i == progLength - 1) answer.add(deployPerDay.get(restDay));
        }
        return answer.stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(result));
    }
}
