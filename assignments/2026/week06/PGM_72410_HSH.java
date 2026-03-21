package week06;

public class PGM_72410_HSH {
    public static void main(String[] args) {
        PGM_72410_HSH sol = new PGM_72410_HSH();
    
        String result = sol.solution("...!@BaT#*..y.abcdefghijklm");
    
        System.out.println(result);
    }    
    public String solution(String new_id) {
        /***
         * 1) new_id 모든 대문자는 소문자로 치환
         * 2) new_id에서 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자는 제거
         * 3) new_id에서 마침표가 두 번 이상 연속된 부분 마침표 하나로 치환할 것
         * 4) new_id에서 마침표가 처음이나 끝이라면 제거할 것
         * 5) new_id가 빈 문자열이면 "a" 대입
         * 6) new_id가 16자리 이상이면 new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거 할 것 > 제거한 후에 마침표가
         * new_id의 맨 끝에 위치하면 그 마침표는 제거 할것
         * 7) new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때 까지 반복해서 끝에 붙이기
         * 
         */
        // step1
        String result = new_id.toLowerCase();
        String regex1 = "[^a-z0-9._-]"; // 소문자, 숫자, ., _, - 제외한 것
        // step2
        result = result.replaceAll(regex1, "");
        // step3
        String regex2 = "\\.{2,}";
        result = result.replaceAll(regex2, ".");
        // step4
        String regex3 = "^[.]|[.]$";
        result = result.replaceAll(regex3, "");

        // step5
        if (result.isEmpty()) {
            result = "a";
        }
        // step6
        String regex4 = "[.]$";
        if (result.length() >= 16) {
            result = result.substring(0, 15).replaceAll(regex4, "");
        }

        // step7
        while (result.length() < 3) {
            result += result.charAt(result.length() - 1);
        }
        return result;
    }
}
