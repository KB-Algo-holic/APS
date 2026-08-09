// 모의고사
// PGM - 42888 오픈채팅방
// 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/42888


import java.util.*;


class Solution {
    public String[] solution(String[] record) {

        //List userId로 sentence
        List<String> list = new ArrayList<String>();


        //Map userId : Nickname
        Map<String, String> userInfo = new HashMap<String, String>();
        Map<String, String> sample = new HashMap<String, String>();
        sample.put("Enter", " 님이 들어왔습니다.");
        sample.put("Leave", " 님이 나갔습니다.");


        for (String sen: record) {
            String[] words = sen.split(" ");

            String tmp = "";
            String command = words[0];
            String userId = words[1];



            if (command.equals("Change")) {
                userInfo.put(userId, words[2]);
            } else if (command.equals("Leave")) {
                tmp = userId + sample.get(command);
            } else if (command.equals("Enter")) {
                tmp = userId + sample.get(command);
                userInfo.put(userId, words[2]);

            }
            if (tmp.length()>0) list.add(tmp);


        }

        String[] answer = new String[list.size()];

        for (int i=0; i<list.size(); i++) {
            String sentence = list.get(i);

            String[] words = sentence.split(" ");
            String nickname = userInfo.get(words[0]);

            String newSentence = nickname + words[1] + " " + words[2];
            answer[i] = newSentence;
        }




        return answer;
    }
}