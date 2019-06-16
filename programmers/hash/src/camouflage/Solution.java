package camouflage;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> numOfClothes = new HashMap<>();
        for (String[] clothe : clothes) {
            numOfClothes.computeIfPresent(clothe[1], (k, v) -> v += 1);
            numOfClothes.putIfAbsent(clothe[1], 1);
        }

        for (String key : numOfClothes.keySet()) {
            answer *= (numOfClothes.get(key) + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new String[][] {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        });
        System.out.println(result);
    }
}
