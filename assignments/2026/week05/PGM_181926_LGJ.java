// PGM - 181926
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181926

import java.util.*;

class Solution {
    public int solution(int n, String control) {
        for (char c: control.toCharArray()) {
            if (c == 'w') n+=1;
            else if (c == 's') n-=1;
            else if (c == 'd') n+=10;
            else if (c == 'a') n-=10;
        }
        return n;
    }
}