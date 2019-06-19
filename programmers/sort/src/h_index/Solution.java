package h_index;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* not resolved */

public class Solution {
    // 문제를 잘못이해했나?
    public int solution(int[] citations) {
        int answer = 0;
        int numOfEssay = citations.length;

        List<Integer> cits = Arrays.stream(citations).boxed()
                .sorted((c1, c2) -> c2 - c1)
                .collect(Collectors.toList());

        for (Integer cit : cits) {
            int restChance = numOfEssay - cit + 1;
            int satisfiedIdx = 0;
            for (Integer comparedCit: cits) {
                if (restChance <= 0) {
                    satisfiedIdx = 0;
                    break;
                }

                if (satisfiedIdx >= cit) break;

                if (comparedCit >= cit) satisfiedIdx++;
                else restChance--;
            }
            if (satisfiedIdx >= cit) {
                answer = satisfiedIdx;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] citations = {1, 2, 3, 4 ,5, 6, 7, 8};
        int result = sol.solution(citations);
        System.out.println(result);
    }
}