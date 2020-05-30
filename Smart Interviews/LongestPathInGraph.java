import java.io.*;
import java.util.*;

public class Solution {
    static int length=0;
    static int dest=0;
     static void BFS(ArrayList<ArrayList<Integer>> Gr,int S){
         int N=Gr.size( );
         boolean vis[ ]=new boolean[N+1];
         Queue<Integer> q=new LinkedList<Integer>( );
         q.add(S);
         q.add(-1);
         vis[S]=true;
         while(q.size( )!=0){
             int u=q.remove( );
             if(u==-1){
                 length++;
                 if(q.size( )!=0)
                 q.add(-1);
                 continue;
             }
             dest=u;
             for(int v:Gr.get(u)){
                 if(vis[v]==false){
                     q.add(v);
                     vis[v]=true;
                 }
             }
         }
     }
    public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    int t=Integer.parseInt(br.readLine( ));
    for(int i=0;i<t;i++){
        length=0;
        dest=0;
      String A[ ]=br.readLine( ).split(" ");
      int N=Integer.parseInt(A[0]);
      int M=Integer.parseInt(A[1]);
       ArrayList<ArrayList<Integer>> Gr=new ArrayList<>( );
        for(int j=0;j<=N;j++)
            Gr.add(new ArrayList<Integer>( ));
        for(int j=0;j<M;j++){
            A=br.readLine( ).split(" ");
            int a=Integer.parseInt(A[0]);
            int b=Integer.parseInt(A[1]);
            Gr.get(a).add(b);
            Gr.get(b).add(a);
        }
        boolean vis1[ ]=new boolean[N+1];
        boolean vis2[ ]=new boolean[N+1];
        BFS(Gr,1);
        length=0;
        BFS(Gr,dest);
        bw.write((length-1)+"\n");
        }
          bw.flush( );
    }
}
