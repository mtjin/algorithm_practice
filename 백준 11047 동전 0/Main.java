import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int moneyCount = sc.nextInt(); // 돈 종류 개수
        int totalMoney = sc.nextInt(); // 전체금액
        int result = 0; // 필요한 최소 동전개수
        ArrayList<Integer> moneyList = new ArrayList<>();

        for(int i=0; i<moneyCount; i++){
            moneyList.add(sc.nextInt());
        }

        Collections.sort(moneyList, Comparator.reverseOrder());

        for(int i=0; i<moneyCount; i++){
            int money = moneyList.get(i);
            result += totalMoney / money;
            totalMoney %= money;
        }

        System.out.println(result);
    }
}

