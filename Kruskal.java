import java.util.Scanner;
public class Kruskal {
    static Scanner sc=new Scanner(System.in);
    static int n;
    static int[][] cost;
    static int[] parent;
    public static void uni(int i,int j){
        parent[j]=i;
    }
    public static int parent(int i){
        while(parent[i]!=0){
            i=parent[i];
        }
        return i;
    }
    public static void kruskal_algo(){
        int ne=1,a=0,b=0,u=0,v=0,mincost=0;
        int min;
        while(ne<n){
            min=999;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(cost[i][j]<min){
                        a=u=i;
                        b=v=j;
                        min=cost[i][j];
                    }
                }
            }
            u=parent(u);
            v=parent(v);
            if(u!=v){
                ne=ne+1;
                System.out.println("("+a+","+b+")");
                uni(u,v);
                mincost=mincost+cost[a][b];
            }
            cost[a][b]=cost[b][a]=999;
        }
        System.out.println("Min Cost="+mincost);
    }
    public static void main(String[] args){
        System.out.println("Enter no of nodes");
        n=sc.nextInt();
        cost=new int[n+1][n+1];
        parent=new int[n+1];
        System.out.println("Enter the cost matrix");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j]=sc.nextInt();
                if(cost[i][j]==0){
                    cost[i][j]=999;
                }
            }
        }
        kruskal_algo();
    }
}
