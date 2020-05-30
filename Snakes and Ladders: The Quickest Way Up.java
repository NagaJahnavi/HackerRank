import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int quickestWayUp(int[][] ladders, int[][] snakes) {
         int C[ ]=new int[101];
         boolean vis[ ]=new boolean[101];
         int l=ladders.length;
         int s=snakes.length;
         for(int i=0;i<l;i++)
             C[ladders[i][0]]=ladders[i][1];
         for(int i=0;i<s;i++)
             C[snakes[i][0]]=snakes[i][1];
        Queue<Integer> Q=new LinkedList<Integer>( );
        Q.add(1);
        vis[1]=true;
        Q.add(-1);
        int level=0,ans=-1;
        while(Q.size( )!=0){
            int a=Q.poll( );
            if(a==-1){
                level++;
                if(Q.size( )!=0)
                  Q.add(-1);


            }
            else if(a==100){
                ans=level;
                break;
            }
            for(int j=1;j<=6;j++){
                int temp=a+j;
                if(temp<1 || temp>100)
                   continue;
                while(C[temp]!=0)
                    temp=C[temp];
                if(temp==100)
                  return level+1;
                if(vis[temp]==false){
                   Q.add(temp);
                   vis[temp]=true;
                }
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] ladders = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] laddersRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int laddersItem = Integer.parseInt(laddersRowItems[j]);
                    ladders[i][j] = laddersItem;
                }
            }

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] snakes = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] snakesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int snakesItem = Integer.parseInt(snakesRowItems[j]);
                    snakes[i][j] = snakesItem;
                }
            }

            int result = quickestWayUp(ladders, snakes);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
