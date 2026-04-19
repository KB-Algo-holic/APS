class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int x=0;
        int y=0;
        for(int i=0 ;i<park.length;i++)
        {
            y = park[i].indexOf('S');
            if(park[i].indexOf('S')!= -1)
            {
                x = i;
                break;
            }
        }
        
        for(int i=0 ;i<routes.length;i++)
        {
            String op = routes[i].split(" ")[0];
            Integer n = Integer.parseInt( routes[i].split(" ")[1]);
            
            // System.out.println(x+" "+y);
            if("E".equals(op))
            {
                if(y+n >= park[x].length())
                {
                    continue;
                }
                boolean stop = false;
                for(int j=0;j<=n;j++)
                {
                    if(park[x].charAt(y+j) == 'X')
                    {
                        stop = true;
                    }
                }
                if(stop)
                {
                    continue;
                }
                y = y+n;
            }
            else if("W".equals(op))
            {
                if(y-n < 0)
                {
                    continue;
                }
                boolean stop = false;
                for(int j=0;j<=n;j++)
                {
                    if(park[x].charAt(y-j) == 'X')
                    {
                        stop = true;
                    }
                }
                if(stop)
                {
                    continue;
                }
                y = y-n;
            }
            else if("S".equals(op))
            {
                if(x+n >= park.length)
                {
                    continue;
                }
                boolean stop = false;
                for(int j=0;j<=n;j++)
                {
                    if(park[x+j].charAt(y) == 'X')
                    {
                        stop = true;
                    }
                }
                if(stop)
                {
                    continue;
                }
                x = x+n;
            }
            else if("N".equals(op))
            {
                if(x-n < 0)
                {
                    continue;
                }
                boolean stop = false;
                for(int j=0;j<=n;j++)
                {
                    if(park[x-j].charAt(y) == 'X')
                    {
                        stop = true;
                    }
                }
                if(stop)
                {
                    continue;
                }
                x = x-n;
            }
        }
        answer[0] = x;
        answer[1] = y;
        // System.out.println("정답"+x+" "+y);
        return answer;
    }
}
