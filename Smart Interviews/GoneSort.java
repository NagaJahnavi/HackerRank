import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int z=Integer.parseInt(br.readLine( ));
        for(int i=0;i<z;i++){
            int l=Integer.parseInt(br.readLine( ));
            String A[ ]=br.readLine( ).split(" ");
            int B[ ]=new int[l];
            HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>( );
            for(int j=0;j<l;j++){
                B[j]=Integer.parseInt(A[j]);
                hm.put(B[j],j);
            }
            int dp[ ]=new int[l];
            dp[0]=1;
            for(int j=1;j<l;j++){
                if(B[j]==1){
                    dp[j]=1;
                    continue;
                }
                int x=hm.get(B[j]-1);
                if(x<j)
                    dp[j]=dp[x]+1;
                else
                    dp[j]=1;
            }
            int max=dp[0];
            for(int j=0;j<l;j++){
                if(dp[j]>max)
                    max=dp[j];
            }
            bw.write((l-max)+"\n");
        }
        bw.flush( );
    }
}
