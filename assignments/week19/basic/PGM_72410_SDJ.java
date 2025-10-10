import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        System.out.println("111 = " + new_id);
        //2. 알파벳,숫자,빼기,밑줄,마침표 제외 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        System.out.println("222 = " + new_id);
        //3, 마침표 2개이상이면 하나로
        new_id = new_id.replaceAll("\\.{2,}", ".");
        System.out.println("333 = " + new_id);
        //4. 마침표가 처음이나 끝에 붙음 제거
        if('.' == new_id.charAt(0)) {
            if(new_id.length() < 2) {
                new_id = "a";
            } else {
                new_id = new_id.substring(1);     
            }
            System.out.println("444 = " + new_id);
        }
        if('.' == new_id.charAt(new_id.length()-1)) {
            new_id = new_id.substring(0, new_id.length()-1);
            System.out.println("555 = " + new_id);
        }
        //5. 빈문자열이면 a
        if(new_id.length()<1) {
            new_id = "a";
            System.out.println("666 = " + new_id);
        }
        //6.길이가 16이상이면 15개까지만, 끝에 . 제거
        if(new_id.length()>15) {
            new_id = new_id.substring(0,15);
            System.out.println("777 = " + new_id);
        }
        if('.' == new_id.charAt(new_id.length()-1)) {
            new_id = new_id.substring(0, new_id.length()-1);
            System.out.println("888 = " + new_id);
        }
        //7. 길이가 2 이하이면 마지막 문자를 3될때까지 붙힘
        if(new_id.length() == 1) {
            new_id = new_id + new_id.charAt(0) + new_id.charAt(0);
            System.out.println("999 = " + new_id);
        }
        if(new_id.length() == 2) {
            new_id = new_id + new_id.charAt(1);
            System.out.println("000 = " + new_id);
        }
        answer = new_id;
        return answer;
    }
}