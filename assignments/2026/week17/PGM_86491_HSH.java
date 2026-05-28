
public class PGM_86491_HSH {
    public static void main(String[] args) {
        PGM_86491_HSH solution = new PGM_86491_HSH();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = solution.solution(sizes);
        System.out.println(result); // Output: 4000
    }

    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }
}