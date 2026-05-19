// PGM 43162 - 네트워크
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

function solution(n, computers) {
    let networkCount = n;
    const parent = Array.from({ length: n }, (_, i) => i);
    function find(x) {
        if (parent[x] === x) return x;
        return parent[x] = find(parent[x]);
    }
    function union(a, b) {
        const rootA = find(a);
        const rootB = find(b);

        if (rootA !== rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }
    computers.forEach((e, i) => {
        for (let j = i + 1; j < n; j++) {
            if (e[j] === 1) {
                if (union(i, j)) {
                    networkCount = networkCount - 1;
                }
            }
        }

    })
    return networkCount;
}