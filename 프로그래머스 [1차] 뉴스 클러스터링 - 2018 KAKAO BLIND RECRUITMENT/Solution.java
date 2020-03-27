import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("handshakee", "shake hands");
    }

    public int solution(String str11, String str22) {
        String str1 = str11.toLowerCase();
        String str2 = str22.toLowerCase();
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap();
        HashMap<String, Integer> map2 = new HashMap();
        ArrayList<String> nList = new ArrayList<>(); //교집합
        ArrayList<String> uList = new ArrayList<>(); //합집합
        String mapKey1;
        String mapKey2;
        int i = 0;
        //str1 초기화
        while (i != str1.length() - 1) {
            mapKey1 = str1.substring(i, i + 2);
            if (isEng(mapKey1)) {
                map1.put(mapKey1, map1.getOrDefault(mapKey1, 0) + 1);
            }
            i++;
        }
        //str2 초기화
        i = 0;
        while (i != str2.length() - 1) {
            mapKey2 = str2.substring(i, i + 2);
            if (isEng(mapKey2)) {
                map2.put(mapKey2, map2.getOrDefault(mapKey2, 0) + 1);
            }
            i++;
        }
        Iterator<Map.Entry<String, Integer>> entries1 = map1.entrySet().iterator();
        while (entries1.hasNext()) {
            Map.Entry<String, Integer> entry = entries1.next();

            // str1 만 값 갖고있거나 더 많이 혹은 똑같이 갖고 있는 경우
            if (entry.getValue() >= map2.getOrDefault(entry.getKey(), 0)) {
                // 합집합 처리(더많은기준으로)
                for (i = 0; i < entry.getValue(); i++) {
                    uList.add(entry.getKey());
                }
                // 교집합 처리(더적은거 기준으로, 겹치는거없으면 0)
                for (i = 0; i < map2.getOrDefault(entry.getKey(), 0); i++) {
                    nList.add(entry.getKey());
                }
                if (map2.getOrDefault(entry.getKey(), 0) != 0) {
                    map2.remove(entry.getKey());
                }
            } else { // str2 가 str1 보다 해당 값 더 많이 갖고 있는 경우
                // 합집합 처리
                for (i = 0; i < map2.get(entry.getKey()); i++) {
                    uList.add(entry.getKey());
                }
                // 교집합 처리
                for (i = 0; i < entry.getValue(); i++) {
                    nList.add(entry.getKey());
                }
                if (map2.getOrDefault(entry.getKey(), 0) != 0) {
                    map2.remove(entry.getKey());
                }
            }
        }
        //남은 map2 꺼 합집합에 추가(str2만 갖고있는 값)
        Iterator<Map.Entry<String, Integer>> entries2 = map2.entrySet().iterator();
        while (entries2.hasNext()) {
            Map.Entry<String, Integer> entry = entries2.next();
            for(i=0; i<entry.getValue(); i++){
                uList.add(entry.getKey());
            }
        }
        //자카드 유사도
        if (uList.size() == 0) {
            return 65536;
        } else {
            answer = (int) ((double) nList.size() / uList.size()*65536);;
            return answer;
        }

    }

    private static boolean isEng(String str) {
        boolean flag = Pattern.matches("^[a-zA-Z]*$", str);
        return flag;
    }
}