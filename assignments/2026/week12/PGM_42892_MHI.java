// PGM 42892 - 길찾기 게임
// 트리
// https://school.programmers.co.kr/learn/courses/30/lessons/42892?language=java

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    static int index = 0, len;
    static int[][] answer;

    public int[][] solution(int[][] nodeinfo) {

        len = nodeinfo.length;
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0; i<len; i++) {
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Collections.sort(list, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return Integer.compare(o2.y, o1.y);
            }
        });

        Tree tree = new Tree(list.get(0));
        for(int i=1; i<list.size(); i++) tree.push(list.get(i));

        answer = new int[2][len];
        pre(tree);
        index=0;
        pro(tree);
        return answer;
    }
    static void pre (Tree tree) {

        answer[0][index++]=tree.node.num;

        if(tree.left!=null) {
            pre(tree.left);
        }
        if(tree.right!=null) {
            pre(tree.right);
        }
    }
    static void pro (Tree tree) {
        if(tree.left!=null) {
            pro(tree.left);
        }
        if(tree.right!=null) {
            pro(tree.right);
        }
        answer[1][index++]=tree.node.num;
    }

    static class Tree {
        Tree left, right;
        Node node;
        public Tree(Node node) {
            this.node = node;
        }
        public void push(Node next) {
            Tree now = this;
            if(now.node.x<next.x) {
                if(now.right==null) now.right=new Tree(next);
                else now.right.push(next);
            }
            else {
                if(now.left==null) now.left=new Tree(next);
                else now.left.push(next);
            }
        }
    }
    static class Node {
        int num, x, y;
        public Node(int num, int x, int y) {
            this.num=num;
            this.x=x;
            this.y=y;
        }
    }
}