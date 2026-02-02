// PGM 147354 - 테이블 해시 함수
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/147354

import java.util.*;

class DataArray{
    int[] dataArray;

    DataArray(int[] dataArray) {
        this.dataArray = dataArray;
    }
}

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        List<DataArray> dataArrays = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            dataArrays.add(new DataArray(data[i]));
        }

        Comparator<DataArray> comparator = new Comparator<DataArray>() {
            @Override
            public int compare(DataArray o1, DataArray o2) {
                if(o1.dataArray[col - 1] - o2.dataArray[col - 1] == 0){
                    return o2.dataArray[0] - o1.dataArray[0];
                } else {
                    return o1.dataArray[col - 1] - o2.dataArray[col - 1];
                }
            }
        };

        Collections.sort(dataArrays, comparator);

        int totalSum = 0;
        for(int i = row_begin; i <= row_end; i++){
            int rowSum = 0;
            for(int j = 0; j < data[0].length; j++) {
                rowSum += dataArrays.get(i - 1).dataArray[j] % i;
            }

            totalSum = totalSum ^ rowSum;
        }

        return totalSum;
    }
}