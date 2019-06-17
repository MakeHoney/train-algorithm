package best_album;

import java.util.*;

public class Solution {
    class Song {
        private int id, play;
        Song (int id, int play) {
            this.id = id;
            this.play = play;
        }

        public int getId() { return this.id; }
        public int getPlay() { return this.play; }
    }

    public int[] solution(String[] genres, int[] plays) {
        int idx = 0;
        Set<String> genreSet = new HashSet<>(Arrays.asList(genres));
        Comparator<Song> playComparator = (o1, o2) -> {
            if (o2.getPlay() == o1.getPlay())
                return o1.getId() - o2.getId();
            return o2.getPlay() - o1.getPlay();
        };

        HashMap<String, Integer> genrePlaySum = new HashMap<>();
        HashMap<String, ArrayList<Song>> hm = new HashMap<>();
        for (String genre: genres) {
            int songId = idx;
            hm.putIfAbsent(genre, new ArrayList<>());
            hm.computeIfPresent(genre, (k, v) -> {
                v.add(new Song(songId, plays[songId]));
                return v;
            });
            idx++;
        }

        // sorting
        for (String genre : genreSet) {
            hm.computeIfPresent(genre, (k, v) -> {
                v.sort(playComparator);
                genrePlaySum.put(genre, v.stream().mapToInt(Song::getPlay).sum());
                return v;
            });
        }

        ArrayList<String> genreRank = new ArrayList<>();

        while(!genrePlaySum.isEmpty()) {
            String maxKey = Collections.max(genrePlaySum.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
            genreRank.add(maxKey);
            genrePlaySum.remove(maxKey);
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        for (String genre : genreRank) {
            answerList.add(hm.get(genre).get(0).getId());
            if (hm.get(genre).size() > 1) {
                answerList.add(hm.get(genre).get(1).getId());
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] genre1 = {"classic", "pop", "classic", "classic", "pop"};
        String[] genre2 = {"classic", "pop", "pop"};
        String[] genre3 = {"hiphop", "classic", "pop", "classic", "classic", "pop"};
        String[] genre4 = {"classic", "hiphop", "hiphop", "hiphop", "hiphop", "hiphop", "hiphop"};
        String[] genre5 = {"classic"};
        String[] genre6 = {"hiphop", "classic", "pop", "pop"};
        int[] play1 = {500, 600, 150, 800, 2500};
        int[] play2 = {500, 800, 100};
        int[] play3 = {2501, 500, 600, 150, 800, 2500};
        int[] play4 = {2501, 2500, 2500, 2500, 2500, 2500, 2500};
        int[] play5 = {1};
        int[] play6 = {2501, 500, 600, 2500};

        int[] foo = sol.solution(genre6, play6);
        System.out.println(Arrays.toString(foo));
    }
}
