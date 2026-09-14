package week32;
public class PGM_72414_HSH {

    public static void main(String[] args) {
        PGM_72414_HSH sol = new PGM_72414_HSH();
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30" };
        System.out.println(sol.solution(play_time, adv_time, logs));        
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {

        int playTime = convertToSeconds(play_time);
        int advTime = convertToSeconds(adv_time);

        long[] viewers = new long[playTime + 2];

        // 1. 차분 배열
        for (String log : logs) {
            String[] times = log.split("-");

            int start = convertToSeconds(times[0]);
            int end = convertToSeconds(times[1]);

            viewers[start]++;
            viewers[end]--;
        }

        // 2. 초별 시청자 수
        for (int i = 1; i <= playTime; i++) {
            viewers[i] += viewers[i - 1];
        }

        // 3. 누적 시청시간
        for (int i = 1; i <= playTime; i++) {
            viewers[i] += viewers[i - 1];
        }

        long maxViewers = viewers[advTime - 1];
        int maxStart = 0;

        // 4. 광고 시작시간 탐색
        for (int start = 1; start <= playTime - advTime; start++) {

            int end = start + advTime - 1;

            long currentViewers = viewers[end] - viewers[start - 1];

            if (currentViewers > maxViewers) {
                maxViewers = currentViewers;
                maxStart = start;
            }
        }

        return convertToTime(maxStart);
    }

    private int convertToSeconds(String time) {
        String[] parts = time.split(":");

        return Integer.parseInt(parts[0]) * 3600
                + Integer.parseInt(parts[1]) * 60
                + Integer.parseInt(parts[2]);
    }

    private String convertToTime(int seconds) {

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        return String.format(
                "%02d:%02d:%02d",
                hours,
                minutes,
                secs);
    }
}