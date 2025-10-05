import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(String[][] relation) {

        ArrayList<Integer> bits = new ArrayList<>();

        int len = relation[0].length;
        int max = 1<<len;
        for(int bit=1; bit<max; bit++) {

            Set<String> set = new HashSet<>();

            for(int i=0; i<relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<len; j++) {
                    if((bit&(1<<j)) > 0) {
                        sb.append(relation[i][j]);
                    }
                }
                set.add(sb.toString());
            }
            if(set.size() == relation.length)
                bits.add(bit);
        }
        Collections.sort(bits);

        for(int i=0; i<bits.size(); i++) {
            for(int j=bits.size()-1; j>i; j--) {
                if((bits.get(i)&bits.get(j))==bits.get(i)) bits.remove(j);
            }
        }

        return bits.size();
    }
}