package kth_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Arrays만 써서 다시 풀어보기

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());
        for (int[] command : commands) {
            List<Integer> subList = new ArrayList<>(arr.subList(command[0] - 1, command[1]));
            subList.sort(Comparator.comparingInt(a -> a));
            answer.add(subList.get(command[2] - 1));
        }

        return answer.stream().mapToInt(el -> el).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = sol.solution(array1, commands1);
        System.out.println(Arrays.toString(result));
    }
}
