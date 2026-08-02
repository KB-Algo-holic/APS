package week26;

public class PGM_340213_HSH {

    public static void main(String[] args) {
        String video_len = "34:33";
        String pos = "13:00";
        String op_start = "00:55";
        String op_end = "02:55";
        String[] commands = { "next", "prev" };

        PGM_340213_HSH solution = new PGM_340213_HSH();

        String result = solution(
                video_len,
                pos,
                op_start,
                op_end,
                commands);

        System.out.println(result);
    }

    public static String solution(
            String video_len,
            String pos,
            String op_start,
            String op_end,
            String[] commands) {
        int videoLength = toSeconds(video_len);
        int currentPosition = toSeconds(pos);
        int openingStart = toSeconds(op_start);
        int openingEnd = toSeconds(op_end);

        // 명령 실행 전 현재 위치가 오프닝 구간인지 확인
        currentPosition = skipOpening(
                currentPosition,
                openingStart,
                openingEnd);

        for (String command : commands) {

            if (command.equals("next")) {
                currentPosition += 10;

                // 영상 길이를 넘어가지 않도록 처리
                currentPosition = Math.min(
                        currentPosition,
                        videoLength);

            } else if (command.equals("prev")) {
                currentPosition -= 10;

                // 0초보다 작아지지 않도록 처리
                currentPosition = Math.max(
                        currentPosition,
                        0);
            }

            // 명령 실행 후 오프닝 구간인지 확인
            currentPosition = skipOpening(
                    currentPosition,
                    openingStart,
                    openingEnd);
        }

        return toTimeFormat(currentPosition);
    }

    /**
     * MM:SS 형식의 시간을 초 단위로 변환
     */
    private static int toSeconds(String time) {
        String[] parts = time.split(":");

        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        return minutes * 60 + seconds;
    }

    /**
     * 현재 위치가 오프닝 구간에 포함되면 오프닝 끝으로 이동
     */
    private static int skipOpening(
            int currentPosition,
            int openingStart,
            int openingEnd) {
        if (currentPosition >= openingStart
                && currentPosition <= openingEnd) {
            return openingEnd;
        }

        return currentPosition;
    }

    /**
     * 초 단위 시간을 MM:SS 형식으로 변환
     */
    private static String toTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}