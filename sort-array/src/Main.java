import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = getList();
        int moves = getMinimumMoves(list);
        System.out.println(moves);
    }

    private static int getMinimumMoves(List<Integer> arr) {
        LinkedList<Integer> ll = new LinkedList<>(arr);
        List<Integer> sl = arr.stream().sorted().toList();

        int count = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (!ll.equals(sl)) {
                if(ll.get(i) != sl.get(i)) {
                    ll.add(ll.get(i));
                    ll.remove(i);
                    count++;
                }
            }
        }

        return count;
    }

    private static List<Integer> getList() {
        return IntStream.of(3, 1, 3, 2).boxed().toList();
        //return IntStream.of(3, 1, 2, 3).boxed().toList();
    }
}