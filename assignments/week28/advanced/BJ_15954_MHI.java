import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);
        String[] second = br.readLine().split(" ");
        double[] dolls = new double[n];

        for(int i=0; i<n; i++) {
            dolls[i] = Double.parseDouble(second[i]);
        }

        double sum = 0;
        double average = 0;
        double pow = 0;
        double result = 0;
        double b=0;

        for(int o=k; o<=n; o++) {
            for(int i=0; i<=n-o; i++) {
                for(int a=i; a<i+o; a++) {
                    sum+=dolls[a];
                }
                average = sum/o;
                for(int j=i; j<i+o; j++) {
                    b= dolls[j];
                    b-=average;
                    if(b<0) b= -b;
                    pow += b*b;
                }
                double re = Math.sqrt(pow/o);
                if(o==k&&i==0)result=re;
                if(result>re) result=re;

                pow=0;
                sum=0;
            }
        }
        System.out.print(result);
    }
}