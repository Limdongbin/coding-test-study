import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        // 완주자 이름별 인원수 저장
        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 참가자를 확인하면서 완주자 수 차감
        for (String name : participant) {
            if (map.getOrDefault(name, 0) == 0) {
                return name;
            }
            map.put(name, map.get(name) - 1);
        }

        return null;
    }
}