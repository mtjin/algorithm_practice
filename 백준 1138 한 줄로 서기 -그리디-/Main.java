import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) { //현재번호
            int left = sc.nextInt(); //나보다 키가 큰 사람이 left 명 있어야함
            for (int j = 1; j <= n; j++) {//배치할번호
                if (left == 0 && arr[j] == 0) { //나보다 왼쪽에 키큰사람이 있어야할 수 만큼 존재하고 아직 배치되지 않은 자리에 자리배치
                    arr[j] = i; // 자리배치
                    break;
                } else if (arr[j] == 0) { //0이면 일단 자신보다 큰 사람이 위치하게 자리비켜줌
                    left--;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}