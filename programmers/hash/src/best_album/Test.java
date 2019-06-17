package best_album;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> foo = new ArrayList<>();
        foo.add("1");
        foo.add("3");
        System.out.println(foo.get(0));
        if (foo.size() > 1) {
            System.out.println(foo.get(1));
        }

        HashMap<Integer, Boolean> genrePlayMax = new HashMap<>();
        genrePlayMax.put(1, true);
        genrePlayMax.put(2, true);
        genrePlayMax.put(3, true);
        int idx = 1;
        while(!genrePlayMax.isEmpty()) {
            genrePlayMax.remove(idx);
            idx++;
        }
        System.out.println(foo);
    }
}
