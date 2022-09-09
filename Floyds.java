import java.util.Scanner;
public class Floyds {
    static int n;
    static int[][] cost;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        ReadMatrix();
        floyd();
        PrintMatrix();
    }
    public static void ReadMatrix(){
        System.out.println("Enter the number of nodes");
        n=sc.nextInt();
        cost=new int[n+1][n+1];
        System.out.println("Enter the cost matrix(999 for infinity");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cost[i][j]=sc.nextInt();
            }
        }
        sc.close();
    }
    public static void floyd(){
        for(int k=1;k<=n;k++)
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    if(cost[i][k]+cost[k][j]<cost[i][j])
                        cost[i][j]=cost[i][k]+cost[k][j];
    }
    public static void PrintMatrix(){
        System.out.println("The answer matrix is");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(cost[i][j]+"\t");
            }
        System.out.println();
        }
    }
}
