import java.util.LinkedList;
import java.util.List;

public class JavaMain {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        String[] strArray = new String[0];

        strArray = list.toArray(new String[list.size()]);
        StringBuilder s = new StringBuilder();
    }

    private void print() {

    }
}
