import java.util.Scanner;
public class Sum_of_Subset {
    static Scanner sc=new Scanner(System.in);
    static int n;
    static int d;
    static int[] S;
    static int[] soln;
    public static void main(String[] args){
        System.out.println("Enter the no of elements");
        n=sc.nextInt();
        System.out.println("Enter the elements in ascending order");
        S=new int[n+1];
        soln=new int[n+1];
        for(int i=1;i<=n;i++){
            S[i]=sc.nextInt();
        }
        System.out.println("ENter the maximum susbset value");
        d=sc.nextInt();
        int sum=0;
        for(int elem:S){
            sum=sum+elem;
        }
        System.out.println("The subsets are");
        if(d<S[1]||sum<d){
            System.out.println("Solution not possible");
            System.exit(0);
        }
        SumofSub(0,0,sum);
    }
    public static boolean isPromising(int i,int weight,int total){
        return ((weight+total>=d)&&(weight==d||weight+S[i+1]<=d));
    } 
    public static void SumofSub(int i,int weight,int total){
        if(isPromising(i, weight, total)==true){
            if(weight==d){
                for(int j=1;j<=n;j++){
                    if(soln[j]==1)
                        System.out.print(j+"\t");
                }
                System.out.println();
            }else{
            soln[i+1]=1;
            SumofSub(i+1, weight+S[i+1], total-S[i+1]);
            soln[i+1]=0;
            SumofSub(i+1, weight, total-S[i+1]);}
        }
    }
}
