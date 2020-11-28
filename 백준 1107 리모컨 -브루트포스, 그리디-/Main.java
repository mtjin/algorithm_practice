import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int page = sc.nextInt();
        int n = sc.nextInt();
        int[] broken = new int[n];
        for (int i = 0; i < broken.length; i++) {
            broken[i] = sc.nextInt();
        }
        int upPage = page;
        int downPage = page;
        int firstPage = 100;
        ArrayList<Integer> numList = new ArrayList<>();
        if (firstPage == page) { //1. 처음부터 숫자 같을때
            System.out.println(0);
            return;
        } else { //2. 처음숫자에서 +,- 로 차잇값
            numList.add(Math.abs(firstPage - page));
        }
        while (upPage < 10000000) { //3. 이 번호보다 높은 값의 번호를 눌렀을때
            String str = String.valueOf(upPage);
            boolean isFind = false;
            for (char c : str.toCharArray()) {
                int num = c - '0';
                for (int bro : broken) {
                    if (bro == num) {
                        upPage += 1;
                        isFind = true;
                        break;
                    }
                }
                if (isFind) break;
            }
            if (!isFind) {
                numList.add(upPage - page + String.valueOf(upPage).length());
                break;
            }
        }

        while (downPage >= 0) {  //4. 이 번호보다 낮은 값의 번호를 눌렀을때
            String str = String.valueOf(downPage);
            boolean isFind = false;
            for (char c : str.toCharArray()) {
                int num = c - '0';
                for (int bro : broken) {
                    if (bro == num) {
                        downPage -= 1;
                        isFind = true;
                        break;
                    }
                }
                if (isFind) break;
            }
            if (!isFind) {
                numList.add(page - downPage + String.valueOf(downPage).length());
                break;
            }
        }
        Collections.sort(numList); //가장 최소한의 횟수
        System.out.println(numList.get(0));
    }
}