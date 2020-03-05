import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCount = sc.nextInt();
        ArrayList<Time> timeList = new ArrayList<Time>();
        int finalTime = 0; // 현재 예약 가능한 최소시간
        int result = 0; // 결과값 (가능한 예약 방개수)
        for (int i = 0; i < totalCount; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            timeList.add(new Time(start, end));
        }

        //정렬
        Collections.sort(timeList);

        // 새로넣는 TIme의 시작시간과 현재 에약 가능한 최소시간 TIme과 시간비교, 들어갈 수 있으면 카운트 +1하고 예약가능한 최소시간 변경
        for (int i = 0; i < totalCount; i++) {
            int startTime = timeList.get(i).start;
            int endTime = timeList.get(i).end;
            if (startTime >= finalTime) {
                finalTime = endTime;
                result++;
            }
        }

        System.out.println(result);
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            // 끝나는시간으로 오름차순 정렬, 만약 끝나는 시간이 같으면 시작시간으로 오름차순 정렬
            if (end == o.end) {
                return start - o.start;
            } else {
                return end - o.end;
            }
        }
    }
}

