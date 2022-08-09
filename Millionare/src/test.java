import java.util.ArrayList;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {

        ArrayList<String> answer = new ArrayList<>();

        answer.add("answer1");
        answer.add("answer2");
        answer.add("answer3");
        answer.add("answer4");


        Iterator<String> iterator = answer.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(iterator.next());

    }
}
