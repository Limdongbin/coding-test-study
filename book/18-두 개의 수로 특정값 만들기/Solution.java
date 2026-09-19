import java.util.*;

public class Solution {

    public static boolean solution(int[] arr, int target) {

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i : arr) {
            if(hashSet.contains(target-i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }
}