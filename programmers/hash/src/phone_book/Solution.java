package phone_book;

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        for (String pivot : phoneBook) {
            int pivotLen = pivot.length();
            for (String el: phoneBook) {
                if (!pivot.equals(el) && pivotLen <= el.length() && el.indexOf(pivot) == 0)
                    return false;
            }
        }
        return true;
    }

    public boolean otherSolution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] str1 = {"119", "97674223", "1195524421"};
        String[] str2 = {"123", "456", "789"};
        boolean result = sol.solution(str2);
        System.out.println(result);
    }
}