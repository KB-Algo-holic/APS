// LC 542 - 01 Matrix
// 유형: 구현
// 링크: https://leetcode.com/problems/01-matrix/
/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var updateMatrix = function (mat) {
    const m = mat.length;
    const n = mat[0].length;

    const dist = Array.from({ length: m }, () => new Array(n).fill(Infinity));

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 0) {
                dist[i][j] = 0;
            } else {
                if (i > 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j > 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
    }

    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (dist[i][j] === 0) continue;

            if (i < m - 1) {
                dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
            }
            if (j < n - 1) {
                dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
    }

    return dist;
};