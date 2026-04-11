package week10;
import java.util.Arrays;
public class PGM_42576_HSH {
    public static void main(String[] args) {
        PGM_42576_HSH sol = new PGM_42576_HSH();
        String participant[] = {
                "leo", "kiki", "eden"
        };
        String completion[] = {
                "eden", "kiki"
        };
        String answer = PGM_42576_HSH.solution(participant, completion);
        System.out.println(answer);
    }  

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")) {
            answer = participant[participant.length - 1];
        }
        return answer;
    }
}
