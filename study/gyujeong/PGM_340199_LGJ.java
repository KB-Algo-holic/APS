public class PGM_340199_LGJ {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            int width = bill[0];
            int length = bill[1];
            if ((wallet[0] >= width && wallet[1] >= length) || (wallet[0] >= length && wallet[1] >= width)) {
                break;
            }

            if ( width >= length) {
                bill[0] = width / 2;
            } else {
                bill[1] = length / 2;
            }
            answer += 1;
        }

        return answer;
    }
}
