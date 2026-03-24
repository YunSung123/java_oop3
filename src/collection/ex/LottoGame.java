package collection.ex;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoGame {

    public static void main(String[] args) {

        Set<Integer> lotto = new TreeSet<>(){};
        Random random = new Random();

        //
        while (lotto.size() < 6) {
            int number = random.nextInt(45) + 1;
            lotto.add(number);
        }
        System.out.println("이번 주 로또 번호 : " + lotto);
        System.out.println("총  " + lotto.size() + "개");
    }
}
