import java.util.Scanner;
public class Travelling_Salesperson {
    static int[][] c;
    static int[] tour;
    final static int MAX=100;
    static int n;
    final static int infinity=999;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter the no of vertices");
        n=sc.nextInt();
        tour=new int[MAX];
        c=new int[MAX][MAX];
        System.out.println("Enter the cost matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                c[i][j]=sc.nextInt();
                if(c[i][j]==0){
                    c[i][j]=999;
                }
            }
        }
        for(int i=0;i<n;i++){
            tour[i]=i;
        }
        int cost=tspdp(c,tour,0,n);
        System.out.println("Minimum cost="+cost);
        for(int i=0;i<n;i++){
            System.out.print(tour[i]+"-->");
        }
        System.out.print("0");
    }
    public static int tspdp(int[][] c,int[] tour,int start,int n){
        int i,j,k;
        int[] temp=new int[MAX];
        int[] mintour=new int[MAX];
        int mincost=infinity;
        int cost;
        if(start==n-2){
            return c[tour[n-2]][tour[n-1]]+c[tour[n-1]][0];
        }
        for(i=start+1;i<n;i++){
            for(j=0;j<n;j++){
                temp[j]=tour[j];
            }
            temp[start+1]=tour[i];
            temp[i]=tour[start+1];
            if(c[tour[start]][tour[i]]+(cost=tspdp(c,temp,start+1,n))<mincost){
                mincost=c[tour[start]][tour[i]]+cost;
                for(k=0;k<n;k++){
                    mintour[k]=temp[k];
                }
            }
        }
        for(i=0;i<n;i++){
            tour[i]=mintour[i];
        }
        return mincost;
    }
}
