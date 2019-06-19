
package h_index;

import java.util.*;
import java.util.stream.Collectors;

/* not resolved */

public class Solution_1 {
    public int solution(int[] citations) {
        int answer = 0;
        int numOfEssay = citations.length;
        List<Integer> satisfiedElement = new ArrayList<>();
        List<Integer> cits = Arrays.stream(citations).boxed()
                .sorted((c1, c2) -> c2 - c1)
                .collect(Collectors.toList());

        for (Integer cit : cits) {
            boolean flag = true;
            boolean restCondition = true;
            int restChance = numOfEssay - cit + 1;
            int counter = 0;
            int satisfiedIdx = 0;

            for (Integer comparedCit: cits) {
                if (restChance <= 0) break;

                if (counter >= cit && flag) {
                    satisfiedIdx = counter;
                    flag = false;
                }

                if (comparedCit >= cit) {
                    satisfiedElement.add(comparedCit);
                    counter++;
                } else {
                    restChance--;
                }
            }
            if (satisfiedElement.size() > satisfiedIdx) {
                int max = Collections.max(satisfiedElement);
                if (max > cit) restCondition = false;
            }
            satisfiedElement.clear();

            if (satisfiedIdx >= cit && restCondition) {
                answer = satisfiedIdx;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] citations = {1, 2, 3, 4, 5, 6, 7, 8};
        int result = sol.solution(citations);
        System.out.println(result);
    }
}
