import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PGM_17686_YHS {
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];

        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<size; i++){
            String strLow = files[i].toLowerCase();
            String head   = "";
            String number = "";
            String tail   = "";

            int headEnd = 0;
            int numberEnd = 0;

            for(int j=0; j<strLow.length(); j++){
                if(headEnd == 0 && Character.isDigit(strLow.charAt(j))){
                    head = strLow.substring(0,j);
                    headEnd = j;
                }
                if(headEnd != 0 && numberEnd == 0 && !Character.isDigit(strLow.charAt(j))){
                    number    = strLow.substring(headEnd, j);
                    numberEnd = j;
                }
            }
            if(numberEnd == 0){
                number = strLow.substring(headEnd);
            }else{
                tail = strLow.substring(numberEnd);
            }
            // System.out.println(head+ "   " +number +"   "+tail);
            list.add(new Node(head, number, tail, i));
        }

        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                if(o1.head.equals(o2.head)){
                    if(Integer.parseInt(o1.number) == Integer.parseInt(o2.number)){
                        return Integer.compare(o1.idx, o2.idx);
                    }
                    return Integer.compare(Integer.parseInt(o1.number), Integer.parseInt(o2.number));
                }
                return o1.head.compareTo(o2.head);
            }
        });

        for(int i=0; i<size; i++){
            answer[i] = files[list.get(i).idx];
        }

        return answer;
    }

    class Node{
        String head;
        String number;
        String tail;
        int idx;

        public Node(String head, String number, String tail, int idx){
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }
    }
}
