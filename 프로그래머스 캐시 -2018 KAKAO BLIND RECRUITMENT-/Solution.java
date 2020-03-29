import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public int solution(int cacheSize, String[] cities) {
        List<String> cityList = new ArrayList<>(cacheSize); // 큰 인덱스일 경우 최근에 사용
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            //캐시사이즈 0인 경우
            if (cacheSize == 0) {
                answer = 5 * cities.length;
                break;
            }
            String city = cities[i].toUpperCase();
            // 캐시 꽉찬 경우
            if (cityList.size() >= cacheSize) {
                // 이미 캐시에 있는 경우 hit 하고 LRU 우선순위 재조정
                if (cityList.contains(city)) {
                    cityList.remove(city);
                    cityList.add(cityList.size(), city);
                    answer += 1;
                } else {
                    //캐시에 없는 경우 cache miss 하고 LRU 우선순위 변경
                    cityList.remove(0);
                    cityList.add(cityList.size(), city);
                    answer += 5;
                }
            } else { //캐시 아직 비어있는 경우
                if (cityList.contains(city)) { // hiy
                    cityList.remove(city);
                    cityList.add(cityList.size(), city);
                    answer += 1;
                } else { //miss
                    cityList.add(cityList.size(), city);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}