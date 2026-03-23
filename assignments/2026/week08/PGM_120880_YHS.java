import java.util.Arrays;
import java.util.Comparator;

public class PGM_120880_YHS {
    public static int[] solution(int[] numlist, int n) {
        int size = numlist.length;
        int[] answer = new int [size];
        Integer arr[] = new Integer[size];

//        Arrays.sort(numlist);
        for(int i=0; i<size ;i++){
            arr[i] = numlist[i];
        }

        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1 - n) == Math.abs(o2 - n)){

                    return Integer.compare(o2, o1);
                }
                return Integer.compare(Math.abs(o1 - n), Math.abs(o2 - n));
            }
        });

        for(int i=0; i<size; i++){
            answer[i] = arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numlist = {1, 2, 3, 4, 5, 6};
        int n = 4;

        System.out.println(Arrays.toString(solution(numlist, n)));
    }
}
