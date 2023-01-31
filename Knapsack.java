import java.util.Scanner;
class Knapsack_datatype{
    int[] weight,profit;
    int capacity;
    int n;
    Scanner sc=new Scanner(System.in);
    public Knapsack_datatype(){
        System.out.println("Enter no of elements");
        n=sc.nextInt();
        System.out.println("Enter capacity of knapsack");
        capacity=sc.nextInt();
        weight=new int[n];
        profit=new int[n];
        System.out.println("Enter the weights of the items");
        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
        }
        System.out.println("Enter the profits of the items");
        for(int i=0;i<n;i++){
            profit[i]=sc.nextInt();
        }
    }
    public void fill(){
        int[][] k=new int[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0 || j==0){
                    k[i][j]=0;
                }
                else if(j<weight[i-1]){
                    k[i][j]=k[i-1][j];
                }
                else{
                    k[i][j]=Math.max(k[i-1][j],profit[i-1]+k[i-1][j-weight[i-1]]);
                }
            }
        }
        System.out.println("Max profit="+k[n][capacity]);
        System.out.println("Items Considered");
        int i=n,j=capacity;
        while(i>0 && j>0){
            if(k[i][j]!=k[i-1][j]){
                System.out.println(i+"\t");
                j=j-weight[i-1];
            }
            i=i-1;
        }
    }
}
public class Knapsack {
    public static void main(String[] args){
        Knapsack_datatype k=new Knapsack_datatype();
        k.fill();
    }
}
