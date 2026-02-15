import java.util.ArrayList;

class Solution {

    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++) {
            if('a'<=str1.charAt(i)&&str1.charAt(i)<='z'&&'a'<=str1.charAt(i+1)&&str1.charAt(i+1)<='z') {
                list1.add(str1.substring(i,i+2));
            }
        }
        for(int i=0; i<str2.length()-1; i++) {
            if('a'<=str2.charAt(i)&&str2.charAt(i)<='z'&&'a'<=str2.charAt(i+1)&&str2.charAt(i+1)<='z') {
                list2.add(str2.substring(i,i+2));
            }
        }
        if(list1.size()==0&&list2.size()==0) return 65536;
        else if(list1.size()==0||list2.size()==0) return 0;
        double same=0;
        int sum=list1.size()+list2.size();

        for(String next : list1) {
            for(int i=0; i<list2.size(); i++) {
                if(next.equals(list2.get(i))) {
                    list2.remove(i);
                    same++;
                    break;
                }
            }
        }
        double answer = same/(sum-same);
        return (int)(answer*65536);
    }
}