import java.nio.CharBuffer;
import java.util.*;
import java.util.stream.Collectors;

public class JavaMain {

    public static void main(String[] args) {
        System.out.println(new MyTestString());
        ArrayList<Integer> linkedList = new ArrayList<Integer>(); {}
        Random r = new Random();
        int [] aaa = new int[2];
        for (int i = 0; i < 10; i++) {
            linkedList.add(r.nextInt(100));
        }
         HashMap<Character, Boolean> hm = new HashMap<>();
       int a = (int)(1L);
        System.out.println(linkedList);
        System.out.println();
        System.out.println(linkedList.stream().map(i -> i * i).filter(i -> i / 2 != 0).sorted().collect(Collectors.toUnmodifiableList()));

        System.out.println(linkedList);

    }

    private void print() {

    }
}
