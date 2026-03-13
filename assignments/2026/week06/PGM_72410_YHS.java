public class PGM_72410_YHS {
    public String solution(String new_id) {
        String answer = "";

        // 1
        answer = new_id.toLowerCase();

        // 2
        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        // 3
        answer = answer.replaceAll("\\.{2,}", ".");

        // 4-1
        if(answer.length() > 0){
            if(answer.charAt(0) == '.') {
                if(answer.length() > 1){
                    answer = answer.substring(1);
                }else{
                    answer = "";
                }
            }
        }

        // 4-2
        if(answer.length() > 0){
            if(answer.charAt(answer.length()-1) == '.') {
                if(answer.length() > 1){
                    answer = answer.substring(0, answer.length()-1);
                }else{
                    answer = "";
                }
            }
        }

        // 5
        if(answer.equals("")){
            answer = "a";
        }

        // 6
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);

            if(answer.charAt(answer.length()-1) == '.') {
                if(answer.length() > 1){
                    answer = answer.substring(0, answer.length()-1);
                }else{
                    answer = "";
                }
            }
        }

        // 7
        if(answer.length() <= 2){
            String s = answer.charAt(answer.length()-1) + "";

            while(answer.length() < 3){
                answer += s;
            }
        }


        return answer;
    }
}
