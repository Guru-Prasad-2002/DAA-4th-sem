import java.util.Scanner;
public class Hamiltonian{
    Scanner sc=new Scanner(System.in);
    boolean found=false;
    int n;
    int[][] G;
    int[] x;
    public static void main(String[] args){
        Hamiltonian h=new Hamiltonian();
        h.getData();
        h.hamil(2);
        h.solutionprint();
    }
    public void solutionprint(){
        if(found==false){
            System.out.println("No Solution Possible");
            System.exit(0);
        }
    }
    public void getData(){
        System.out.println("Enter the no of node");
        int i,j;
        n=sc.nextInt();
        x=new int[n+1];
        G=new int[n+1][n+1];
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                if(i!=j && i<j){
                    System.out.print(i+" and "+j);
                        G[i][j]=G[j][i]=sc.nextInt();}
                if(i==j){
                    G[i][j]=0;
                }
            }
        }
        for(i=1;i<=n;i++){
            x[i]=0;
        }
        x[1]=1;
    }
    public void hamil(int k){
        while(true){
        getNext(k);
        if(x[k]==0){
            return;
        }
        else if(k==n){
            found=true;
            for(int i=1;i<=n;i++){
                System.out.print(x[i]+"\t");
            }
            System.out.print(x[1]+"\t");
            System.out.println();
        }
        else{
            hamil(k+1);
        }
    }
}
    public void getNext(int k){
        while(true){
        x[k]=(x[k]+1)%(n+1);
        if(x[k]==0){
            return;
        }
        if(G[x[k-1]][x[k]]!=0){
            int j;
            for(j=1;j<k;j++){
                if(x[j]==x[k])
                    break;
            }
            if(j==k){
                if(k<n||(k==n)&&G[x[k]][x[1]]!=0){
                    return;
                }
            }
        }
    }
}
}