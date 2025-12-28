class Solution {
    public String solution(String m, String[] musicinfos) {

        int t=0;
        String ans="(None)";

        for(int i=0; i<musicinfos.length; i++) {
            String[] line = musicinfos[i].split(",");

            int start, end, len=0;

            String[] time = line[0].split(":");
            start = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            time = line[1].split(":");
            end = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            String name = line[2];

            for(char next : line[3].toCharArray()) {
                if(next!='#') len++;
            }
            String[] music = new String[len];
            int index=0;

            for(int j=0; j<line[3].length(); j++) {
                if(j==line[3].length()-1) music[index]=line[3].substring(j);
                else if(line[3].charAt(j+1)!='#') {
                    music[index++]=line[3].substring(j,j+1);
                }
                else {
                    music[index++]=line[3].substring(j,j+2);
                    j++;
                }
            }

            if(end-start>t) {
                int a = (end-start)/len;
                int b = (end-start)%len;
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<a; j++) sb.append(line[3]);
                for(int j=0; j<b; j++) sb.append(music[j]);
                String word = sb.toString();
                index=0;
                while((index = word.indexOf(m,index))>=0) {
                    if(index+m.length()==word.length()||word.charAt(index+m.length())!='#') {
                        t=end-start;
                        ans=name;
                        break;
                    }
                    index++;
                }
            }
        }
        return ans;
    }
}