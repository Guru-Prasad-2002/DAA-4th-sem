import java.util.Scanner;
public class Prims {
    static Scanner sc=new Scanner(System.in);
    static int n;
    static int[][] cost;
    public static void ReadMatrix(){
        System.out.println("Enter no of nodes");
        n=sc.nextInt();
        cost=new int[n+1][n+1];
        System.out.println("Enter the cost matrix");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j]=sc.nextInt();
                if(cost[i][j]==0){
                    cost[i][j]=999;
                }
            }
        }
    }
    public static void prims_algo(){
        int ne=1,u=0,v=0;
        int[] visited=new int[n+1];
        int mincost=0;
        int min;
        while(ne<n){
            min=999;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(cost[i][j]<min){
                        min=cost[i][j];
                        u=i;
                        v=j;
                    }
                }
            }
            if(visited[u]==0||visited[v]==0){
                ne=ne+1;
                System.out.println("("+u+","+v+")");
                mincost=mincost+min;
                visited[v]=1;
            }
            cost[u][v]=cost[v][u]=999;
        }
        System.out.println("Minimum Cost="+mincost);
    }
    public static void main(String[] args){
        ReadMatrix();
        prims_algo();
    }
}
