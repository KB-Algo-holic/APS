import java.util.ArrayList;

public class PGM_42586_YHS {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int size = progresses.length;

        int deploy[] = new int[size];
        for(int i=0; i<size; i++){
            if((100-progresses[i]) % speeds[i] == 0){
                deploy[i] = (100-progresses[i]) / speeds[i];
            }else{
                deploy[i] = (100-progresses[i]) / speeds[i] + 1;
            }
        }
        // System.out.println(Arrays.toString(deploy));

        ArrayList<Integer> list = new ArrayList<>();

        int cur = 0;
        for(int i=0; i<size; i++){
            if(cur < deploy[i]){
                cur = deploy[i];
            }

            int cnt = 0;

            for(int j=i; j<size; j++){
                if(cur >= deploy[j]){
                    cnt++;
                }else{
                    break;
                }
                i=j;
            }
            list.add(cnt);
        }

        // System.out.println(list);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
