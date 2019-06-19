package iron_stick;

import java.util.Stack;

public class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        int arrangementLength = arrangement.length();
        int lastIdx = arrangementLength - 1;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arrangementLength; i++) {
            char curChar = arrangement.charAt(i);
            char pastChar = i > 0 ? arrangement.charAt(i - 1) : '\0';

            if (curChar == '(') {
                stack.push(curChar);
            } else {
                if (i != lastIdx) stack.pop();

                if (pastChar == '(' || i == lastIdx) answer += stack.size();
                else answer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution("()(((()())(())()))(())");
        System.out.println(result);
    }
}
