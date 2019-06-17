package best_album;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1 {
    public class Song implements Comparable<Solution_1.Song> {
        private int id;
        private int played;
        private String genre;
        public Song(String genre, int id, int played) {
            this.genre = genre;
            this.id = id;
            this.played = played;
        }

        @Override
        public int compareTo(Solution_1.Song other) {
            if (this.played == other.played)return this.id - other.id;
            return other.played - this.played;
        }

        public String getGenre() { return genre; }
        public int getPlayed() { return played; }
        public int getId() { return id; }
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Solution_1.Song(genres[i], i, plays[i]))
                .collect(Collectors.groupingBy(Solution_1.Song::getGenre))
                .entrySet().stream()
                .sorted((e1, e2) -> sum(e2.getValue()) - sum(e1.getValue()))
                .flatMap(e -> e.getValue().stream().sorted().limit(2))
                .mapToInt(Solution_1.Song::getId)
                .toArray();
    }

    public int sum(List<Solution_1.Song> songList) {
        return songList.stream().mapToInt(Solution_1.Song::getPlayed).sum();
    }

    public static void main(String[] args) {
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

        Solution_1 sg = new Solution_1();
        int[] result = sg.solution(genre3, play3);
        System.out.println(Arrays.toString(result));
    }
}
