import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PGM_42746_YHS {
    public static String solution(int[] numbers) {
        String answer = "";

        int size = numbers.length;
        String [] strNums = new String[size];
        for(int i=0; i<size; i++){
            strNums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
//        System.out.println(Arrays.toString(strNums));
        answer = String.join("", strNums);
        if (answer.charAt(0) == '0'){
            return "0";
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9, 100, 10, 56, 566, 0 ,0};
        System.out.println(solution(numbers));
    }
}
