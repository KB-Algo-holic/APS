/**
 * 아래 주석 양식을 필히 작성하여 주세요.
 * # PGM 1234 - 완전범죄
 * # 유형: 이분 탐색
 * # 링크: https://school.programmers.co.kr/learn/courses/30/lessons/389480?language=python3
  */

class Solution {
    val dp: Array<Array<Int>> = Array(40) { Array(121) { -1 } }
    lateinit var infoA: Array<Int>
    lateinit var infoB: Array<Int>
    var N = 0
    var M = 0
    var len = 0
    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        infoA = info.map { it[0] }.toTypedArray()
        infoB = info.map { it[1] }.toTypedArray()
        N = n
        M = m
        len = info.size

        val ans = makeAns(0, 0)

        return if (ans < N) ans else -1
    }
    fun makeAns(i: Int, 남긴흔적: Int): Int {
        if (i == len) return 0

        if (dp[i][남긴흔적] >= 0) return dp[i][남긴흔적]

        val total = infoB[i] + 남긴흔적

        dp[i][남긴흔적] = if (total < M) {
            val a = infoA[i] + makeAns(i + 1, 남긴흔적)
            val b = makeAns(i + 1, total)

            minOf(a, b)
        } else {
            infoA[i] + makeAns(i + 1, 남긴흔적)
        }

        return dp[i][남긴흔적]
    }
}