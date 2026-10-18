// LC - 1079 Letter Tile Possibilities
// 순열
// https://leetcode.com/problems/letter-tile-possibilities/description/
import java.util.HashSet;
import java.util.Set;

public class LC_1079_YHS {
    char[] result, arr;
    boolean[] isSelected;
    Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        int size = tiles.length();
        arr = new char[size];
        result = new char[size];
        isSelected = new boolean[size];

        for(int i=0; i<size; i++){
            arr[i] = tiles.charAt(i);
        }

        // System.out.println(Arrays.toString(arr));

        // combi(0, 0);
        permu(0);

        // System.out.println(set);

        return set.size();
    }

    void permu(int cnt){
        if(cnt > 0){
            String str = "";
            for(int i=0; i<cnt; i++){
                str += result[i];
            }
            set.add(str);
        }
        if(cnt == arr.length){
            // System.out.println(Arrays.toString(result));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            result[cnt] = arr[i];
            permu(cnt+1);
            isSelected[i] = false;
        }

    }

    // void combi(int start, int cnt){
    //     if(cnt == arr.length){
    //         System.out.println(Arrays.toString(result));
    //         return;
    //     }

    //     for(int i=start; i<arr.length; i++){
    //         result[cnt] = arr[i];
    //         combi(i+1, cnt+1);
    //     }
    // }
}
