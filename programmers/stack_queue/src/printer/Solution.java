package printer;

import java.util.LinkedList;

public class Solution {
    public class Paper {
        private int priority;
        private boolean mine;
        public Paper (int priority, boolean mine) {
            this.priority = priority;
            this.mine = mine;
        }
        public int getPriority() { return this.priority; }
        public boolean isMine() { return this.mine; }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Paper> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            Paper paper = i == location
                    ? new Paper(priorities[i], true)
                    : new Paper(priorities[i], false);
            queue.add(paper);
        }

        while (!queue.isEmpty()) {
            Paper curPaper = queue.peek();
            int curPriority = curPaper.getPriority();
            int priorityMax = queue.stream().mapToInt(Paper::getPriority).max().orElse(0);
            if (curPriority < priorityMax) {
                queue.add(queue.remove());
            } else {
                Paper printedPaper = queue.remove();
                answer++;

                if (printedPaper.isMine()) break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(result);
    }
}
