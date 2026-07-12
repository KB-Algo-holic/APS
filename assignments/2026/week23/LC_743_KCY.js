
// LC 743 - Network Delay Time
// 유형: 최단경로
// 링크: https://leetcode.com/problems/network-delay-time/
/**
 * @param {number[][]} times
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var networkDelayTime = function (times, n, k) {
    const graph = Array.from({ length: n + 1 }, () => []);
    for (const [u, v, w] of times) {
        graph[u].push([v, w]);
    }

    const pq = new PriorityQueue((a, b) => a[0] - b[0]);
    pq.enqueue([0, k]);

    const dist = new Map();

    while (!pq.isEmpty()) {
        const [time, node] = pq.dequeue();

        if (dist.has(node)) continue;

        dist.set(node, time);

        for (const [nextNode, nextTime] of graph[node]) {
            if (!dist.has(nextNode)) {
                pq.enqueue([time + nextTime, nextNode]);
            }
        }
    }

    return dist.size === n ? Math.max(...dist.values()) : -1;
};