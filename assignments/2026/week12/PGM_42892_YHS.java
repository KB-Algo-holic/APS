import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// PGM - 42892 L3_길찾기게임
// 트리
// https://school.programmers.co.kr/learn/courses/30/lessons/42892
public class PGM_42892_YHS {
    Node root;
    int[][] answer;
    int idx;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];

        List<Node> list = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++){
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                if(o1.y == o2.y){
                    return Integer.compare(o1.x, o2.x);
                }
                return Integer.compare(o2.y, o1.y);
            }
        });

        for(int i=0; i<list.size(); i++){
            insert(root, list.get(i));
        }

        preOrder(root);
        idx = 0;
        postOrder(root);

        return answer;
    }

    void preOrder(Node node){
        if(node == null){
            return;
        }
        answer[0][idx++] = node.no;
        // System.out.println(node.no);
        preOrder(node.left);
        preOrder(node.right);
    }

    void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        answer[1][idx++] = node.no;
        // System.out.println(node.no);
    }

    void insert(Node parent, Node child){
        if(root == null){
            root = child;
            return;
        }

        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                insert(parent.left, child);
            }
        }else{
            if(parent.right == null){
                parent.right = child;
            }else{
                insert(parent.right, child);
            }
        }
    }

    class Node{
        int no;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int no, int x, int y){
            this.no = no;
            this.x = x;
            this.y = y;
        }
    }
}
