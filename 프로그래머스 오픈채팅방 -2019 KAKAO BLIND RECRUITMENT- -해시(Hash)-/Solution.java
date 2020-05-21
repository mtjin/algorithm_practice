import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
    }

    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap();
        ArrayList<String> result = new ArrayList<>();
        String[] answer = {};

        // 최종 이름 설정
        for (String str : record) {
            switch (str.split(" ")[0]) {
                case "Enter":
                case "Change":
                    String uid = str.split(" ")[1];
                    String name = str.split(" ")[2];
                    map.put(uid, name);
                    break;
            }
        }
        // 출력문 만들기
        for (String str : record) {
            switch (str.split(" ")[0]) {
                case "Enter":
                    result.add(map.get(str.split(" ")[1] ) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    result.add(map.get(str.split(" ")[1]) + "님이 나갔습니다.");
                    break;
            }
        }
        answer = result.toArray(new String[result.size()]);
        return answer;
    }
}