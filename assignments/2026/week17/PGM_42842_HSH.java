public class PGM_42842_HSH {
    public static void main(String[] args) {
        PGM_42842_HSH solution = new PGM_42842_HSH();
        int brown = 10;
        int yellow = 2;
        int[] result = solution.solution(brown, yellow);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Output: [4, 3]
    }

    public int[] solution(int brown, int yellow) {
        int totalTiles = brown + yellow; // brown + yellow -> 이거 제곱수 사이의 값일때 시작 위치의 제곱수 곱하기 남은 값해서 리턴하면 됨
        
        for(int width = totalTiles - 1; width > Math.sqrt(totalTiles) - 1; width--) {
            if(totalTiles % width != 0) continue; // 나누어 떨어지지 않을 때 넘어가기 
            int height = totalTiles / width;
            int yellowTiles = (width - 2) * (height - 2); // 노란색 타일은 항상 쌓여져 있기에 전체 너비보다 2칸 작고 높이보다 2칸 작은 영역에 위치함
            int brownTiles = totalTiles - yellowTiles; // 전체 - 노란타일 = 갈색타일

            if(yellowTiles == yellow && brownTiles == brown) {
                return new int[]{width, height};
            }
        }
        return new int[]{0, 0}; // Return a default value if no solution is found
    }
}
