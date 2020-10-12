import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] minusArr = str.split("\\-");
        int result = 0;
        for (int i = 0; i < minusArr.length; i++) {
            String[] plusArr = minusArr[i].split("\\+");
            for (int j = 0; j < plusArr.length; j++) {
                if (i == 0) {
                    result += Integer.parseInt(plusArr[j]);
                } else {
                    result -= Integer.parseInt(plusArr[j]);
                }
            }
        }
        System.out.println(result);
    }
}