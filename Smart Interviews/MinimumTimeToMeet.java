import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Solution {
    static int X[ ]={-1,1,0,0};
    static int Y[ ]={0,0,1,-1};
     static boolean isValid(int a,int b,int n,int m){
         return (a>=0 && a<n && b>=0 && b<m);
     }
     static void bfs(int i,int j,int n,int m,int T[ ][ ],int V[ ][ ],int B[ ][ ]){
        Queue<Pair> Q=new LinkedList<Pair>( );
         boolean vis[ ][ ]=new boolean[n][m];
         Q.add(new Pair(i,j));
         V[i][j]+=1;
         vis[i][j]=true;
         Q.add(null);
         int level=1;
         while(Q.size( )!=0){
             Pair p=Q.poll( );
             if(p==null){
                 level++;
                 if(Q.size( )!=0)
                     Q.add(null);
                 continue;
             }
             int a=p.x;
             int b=p.y;
             for(int k=0;k<4;k++){
                 int t1=a+X[k];
                 int t2=b+Y[k];
                 if(isValid(t1,t2,n,m) && B[t1][t2]!=1 && vis[t1][t2]==false){
                     Q.add(new Pair(t1,t2));
                     V[t1][t2]+=1;
                     if(level>T[t1][t2])
                         T[t1][t2]=level;
                     vis[t1][t2]=true;
                 }
             }
         }
     }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int q=Integer.parseInt(br.readLine( ));
        for(int i=0;i<q;i++){
            int n,m,x;
            String A[ ]=br.readLine( ).split(" ");
            n=Integer.parseInt(A[0]);
            m=Integer.parseInt(A[1]);
            x=Integer.parseInt(A[2]);
            int B[ ][ ]=new int[n][m];
            int V[ ][ ]=new int[n][m];
            int T[ ][ ]=new int[n][m];
            for(int j=0;j<n;j++){
                String Z=br.readLine( );
                for(int k=0;k<m;k++){
                    if(Z.charAt(k)=='2')
                        B[j][k]=2;
                    else if(Z.charAt(k)=='0')
                        B[j][k]=0;
                    else 
                        B[j][k]=1;
                }
            }
           for(int j=0;j<n;j++){
               for(int k=0;k<m;k++){
                   if(B[j][k]==2)
                       bfs(j,k,n,m,T,V,B);
               }
           }
            int ans=Integer.MAX_VALUE;
            boolean flag=false;
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(V[j][k]==x && T[j][k]<ans){
                        ans=T[j][k];flag=true;
                    }
                }
            }
            if(flag)
              bw.write(ans+"\n");
            else
              bw.write(-1+"\n");
        }
        bw.flush( );
    }
}
