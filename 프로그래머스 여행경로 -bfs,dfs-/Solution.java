import java.util.ArrayList;
import java.util.Collections;

class Solution {
    int size = 0;
    String[][] tickets;
    ArrayList<String> resultList = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] isVisited;
        this.tickets = tickets;
        size = tickets.length;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                isVisited = new boolean[tickets.length];
                String start = tickets[i][0];
                String end = tickets[i][1];
                String history = tickets[i][0];
                isVisited[i] = true;
                Flight flight = new Flight(start, end, history, 1, isVisited);
                dfs(flight);
            }
        }
        //정렬
        Collections.sort(resultList);
        answer = resultList.get(0).split(",");
        return answer;
    }

    void dfs(Flight flight) {
        for (int i = 0; i < size; i++) {
            if (flight.cnt == size) {
                String history = flight.history + "," + flight.end;
                resultList.add(history);
                continue;
            }
            boolean[] isVisited = flight.isVisited.clone();
            String currentEnd = flight.end;
            String nextStart = tickets[i][0];
            if (!isVisited[i] && currentEnd.equals(nextStart)) {
                String history = flight.history + "," + nextStart;
                isVisited[i] = true;
                dfs(new Flight(tickets[i][0], tickets[i][1], history, flight.cnt + 1, isVisited));
            }
        }
    }

    class Flight {
        String start; //출발지
        String end; //도착지
        String history; //기록
        int cnt; // 공항 이동 총 횟수
        boolean[] isVisited; // 공항 방문 여부

        public Flight(String start, String end, String history, int cnt, boolean[] isVisited) {
            this.start = start;
            this.end = end;
            this.history = history;
            this.cnt = cnt;
            this.isVisited = isVisited;
        }
    }
}