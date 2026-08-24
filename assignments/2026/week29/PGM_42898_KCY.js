// PGM 42898 - 등굣길
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42898
function solution(m, n, puddles) {
    const dp = [];
    for (let i = 0; i <= n; i++) {
        dp.push(new Array(m + 1).fill(0));
    }

    for (let i = 0; i < puddles.length; i++) {
        const [x, y] = puddles[i];
        dp[y][x] = -1;
    }

    dp[1][1] = 1;

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if (i === 1 && j === 1) continue;

            if (dp[i][j] === -1) {
                dp[i][j] = 0;
            } else {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
    }

    return dp[n][m];
}