import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();

        char[] answer = new char[word1.length()];
        int index = 0;

        for(int i=0; i<word1.length(); i++) {
            answer[index] = word1.charAt(i);

            if(answer[index]==word2.charAt(word2.length()-1)) {
                if(index-word2.length()+1>=0) {
                    int count = index-word2.length()+1;

                    for(int j=0; j<word2.length(); j++)
                        if(answer[count++]==word2.charAt(j)) {
                            if(j==word2.length()-1) index-=word2.length();
                        }
                        else break;
                }
            }
            index++;
        }
        String s = String.valueOf(answer).substring(0,index);
        if(s.length()==0) System.out.print("FRULA");
        else System.out.print(s);



    }
}