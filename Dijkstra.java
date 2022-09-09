import java.util.Scanner;
public class Dijkstra {
    static Scanner sc=new Scanner(System.in);
    static int n;
    static int[][] cost;
    static int[] visited;
    static int[] distance;
    static int source;
    public static void ReadMatrix(){
        System.out.println("Enter no of nodes");
        n=sc.nextInt();
        cost=new int[n+1][n+1];
        visited=new int[n+1];
        distance=new int[n+1];
        System.out.println("Enter the cost matrix");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j]=sc.nextInt();
                if(cost[i][j]==0){
                    cost[i][j]=999;
                }
            }
        }
        System.out.println("Enter the source vertex");
        source=sc.nextInt();
        for(int i=1;i<=n;i++){
            visited[i]=0;
            distance[i]=cost[source][i];
        }
        visited[source]=1;
        distance[source]=1;
    }
    public static int NextNode(){
        int min=999;
        int i,j=0;
        for(i=1;i<=n;i++){
            if(distance[i]<min && visited[i]==0){
                min=distance[i];
                j=i;
            }
        }
        return j;
    }
    public static void dijkstra_algo(){
        int ne=1;
        int u,v;
        while(ne<n){
            u=NextNode();
            visited[u]=1;
            for(v=1;v<=n;v++){
                if(distance[u]+cost[u][v]<distance[v]){
                    distance[v]=distance[u]+cost[u][v];
                }
            }
            ne=ne+1;
        }
        System.out.println("Distance array is as folows");
        for(int i=1;i<=n;i++){
            if(i!=source)
                System.out.print(distance[i]+"\t");
        }
    }
    public static void main(String[] args){
        ReadMatrix();
        dijkstra_algo();
    }
}
