package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PGM_92334_HSH {
    public static void main(String[] args) {
        /***
         * 서로 다른 유저를 계속해서 신고 가능
         * 한 유저를 여러번 신고할 수 있지만 동일한 유저에 대한 신고 횟수는 1회로 처리
         * 
         */
        String[] idList = {
                "muzi",
                "frodo",
                "apeach",
                "neo"
        };
        String[] reportList = {
                "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"
        };

        int[] answer = solution(idList, reportList, 2);

        System.out.print(Arrays.toString(answer));
    }

     public static int[] solution(String[] id_list, String[] report, int k) {

        /*
         * 1) id_list에서 유저를 뽑는데, Key는 범죄자로하고 Value는 신고자로한다.
         * 범죄자 -> 신고자 목록 
         */
        Map<String, List<String>> reportList = new HashMap<>();
        int result[] = new int[id_list.length];
        
        for(String user: id_list) {
        	reportList.put(user, new ArrayList<>());
        }
        
        // 중복 신고 제거
        for(String user: report) {
        	String[] parts = user.split(" ");
        	String reporter = parts[0];
        	String criminal = parts[1];
        	// 범죄자를 키로해서 신고자를 넣어주기 (중복X)
        	if(!reportList.get(criminal).contains(reporter)) {
        		reportList.get(criminal).add(reporter);
        	}
        }
        
        // K번 이상 신고 당한 유저의 신고자들에게 카운트 증가
        for(String criminal: reportList.keySet()) { 
        	if(reportList.get(criminal).size() >= k) {
        		// 한 범죄자에 연관된 제보리스트 사이즈가 k 이상일 경우
        		for(String user: reportList.get(criminal)) {
        			// 제보자 사용자들로 해서 횟수를 늘려줄 것
        			result[Arrays.asList(id_list).indexOf(user)] += 1; // 제보자의 인덱스만큼 해서 이걸 키로 잡고 갯수 늘려주기
        		}
        	}
        }
        return result;
    }
}