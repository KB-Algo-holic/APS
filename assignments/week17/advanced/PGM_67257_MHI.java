class Solution {
    static char[] how = {'+','-','*'};
    static Long max=Long.MIN_VALUE;
    public long solution(String expression) {
        for(int i=0; i<3; i++) makeAnswer((1<<i), i, expression);
        return max;
    }
    static void makeAnswer(int bit, int next, String line) {
        StringBuilder sb = new StringBuilder();
        char preHow=0, nowHow=0;
        int from=0;
        long number=0;
        for(int i=0; i<line.length(); i++) {
            if((from!=i&&(line.charAt(i)=='+'||line.charAt(i)=='-'||line.charAt(i)=='*'))||i==line.length()-1) {
                nowHow = line.charAt(i);
                if(i==line.length()-1) i++;
                if(preHow==how[next]) {
                    if(next==0)
                        number+=Long.parseLong(line.substring(from,i));
                    else if(next==1)
                        number-=Long.parseLong(line.substring(from,i));
                    else if(next==2) {
                        number*=Long.parseLong(line.substring(from,i));
                    }
                }
                else {
                    if(preHow!=0) sb.append(number).append(preHow);
                    number=Long.parseLong(line.substring(from,i));
                }
                if(i==line.length()) sb.append(number);
                preHow = nowHow;
                from=i+1;
            }
        }
        if(bit==7) {
            max=Math.max(max, Math.abs(Long.parseLong(sb.toString())));
            return;
        }
        for(int i=0; i<3; i++) {
            if((bit&(1<<i))==0) {
                makeAnswer(bit|(1<<i), i, sb.toString());
            }
        }
    }
}