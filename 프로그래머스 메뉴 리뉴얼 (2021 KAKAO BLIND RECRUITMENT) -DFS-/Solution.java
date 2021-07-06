import java.util.*;

class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private Set<String> set = new HashSet<>();
    private boolean[] isVisited;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"ABCD", "ABCD", "ABCD"}, new int[]{2, 3, 4});
    }

    public String[] solution(String[] orders, int[] courses) {
        for (String order : orders) { //각 요리 탐색 및 조합
            for (int course : courses) { // 초기화 및 탐색
                isVisited = new boolean[order.length()];
                set = new HashSet<>();
                dfs("", order, course, isVisited);
            }
        }
        int max = 2; //최소 2개이상은 주문되었어야함
        List<String> resultList = new ArrayList<>(); // 최종 메뉴 담을 리스트 (답)
        List<String> tmpList = new ArrayList<>(); //코스 별 메뉴 담을 리스트 -> 각 코스별 메뉴들을 resultList 에 추가할거임
        for (int course : courses) {
            for (String key : map.keySet()) {
                if (course == key.length()) { // 해당 코스개수인 경우
                    if (map.get(key) >= max) {
                        if (map.get(key) == max) { // 최대 메뉴 개수와 같다면 그냥 추가
                            tmpList.add(key);
                        } else { //최대 메뉴 개수보다 더 큰게 나왔다면 리스트 클리어 후 추가
                            tmpList.clear();
                            tmpList.add(key);
                        }
                        max = map.get(key);
                    }
                }
            }
            //최종 메뉴리스트(답)에 추가
            resultList.addAll(tmpList);
            //초기화
            tmpList.clear();
            max = 2;
        }
        //메뉴 정렬 후 정답 리턴
        Collections.sort(resultList);
        String[] answer = new String[resultList.size()];
        for (int i=0; i<resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    private void dfs(String str, String order, int course, boolean[] isVisited) {
        if (str.length() == course) { //코스길이에 해당하는 메뉴만 조합 가능
            char[] c = str.toCharArray();
            Arrays.sort(c); //정렬해줘야함
            String menu = new String(c); // char배열 -> String으로 변환
            if (!set.contains(menu)) { // 해당 메뉴 추가한적 없으면 추가 (중복방지)
                map.put(menu, map.getOrDefault(menu, 0) + 1); // 맵에 메뉴이름(key)과 개수(value) 추가
                set.add(menu);
            }
            return;
        }
        for (int i = 0; i < order.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(str + order.charAt(i), order, course, isVisited);
                isVisited[i] = false;
            }
        }
    }
}