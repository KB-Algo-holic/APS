import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        ArrayList<User> list = new ArrayList<>();
        for(int i=0; i<stages.length; i++) {
            list.add(new User(i, stages[i]));
        }
        Collections.sort(list, (a, b) -> b.stage-a.stage);

        ArrayList<Fail> fail = new ArrayList<>();
        int index=0;
        float pass=0, nonPass=0;

        for(int i=N+1; i>0; i--) {
            pass+=nonPass;
            nonPass=0;
            while(index<list.size()) {
                if(list.get(index).stage==i) {
                    nonPass++;
                    index++;
                }
                else break;
            }
            if(i==N+1) continue;
            else if(nonPass==0) fail.add(new Fail(i, 0));
            else fail.add(new Fail(i, nonPass/(pass+nonPass)));
        }

        Collections.sort(fail, (a, b) -> a.percent==b.percent ? a.stage-b.stage : Float.compare(b.percent, a.percent));
        int[] answer = new int[fail.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i]=fail.get(i).stage;
        }
        return answer;
    }
    static class User{
        int number, stage;
        User(int number, int stage){
            this.number=number;
            this.stage=stage;
        }
    }
    static class Fail{
        int stage;
        float percent;
        Fail(int stage, float percent){
            this.stage=stage;
            this.percent=percent;
        }
    }
}