import java.util.Scanner;
import java.util.Random;
public class Merge_Sort {
    static int[] arr;
    public static void mergesort(int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergesort(low, mid);
            mergesort(mid+1, high);
            merge(low,mid,high);
        }
    }
    public static void merge(int low,int mid,int high){
        int n=high-low+1;
        int[] tarr=new int[n];
        int i=low,j=mid+1,k=0;
        while(i<mid+1 && j<=high){
            if(arr[i]<=arr[j]){
                tarr[k]=arr[i];
                i=i+1;
                k=k+1;
            }
            else{
                tarr[k]=arr[j];
                j+=1;
                k+=1;
            }
        }
        while(i<mid+1){
            tarr[k]=arr[i];
            i=i+1;
            k=k+1;
        }
        while(j<=high){
            tarr[k]=arr[j];
            j+=1;
            k+=1;
        }
        for(int x=0;x<n;x++){
            arr[low+x]=tarr[x];
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        arr=new int[n];
        Random r=new Random();
        for(int i=0;i<n;i++){
            arr[i]=r.nextInt(200);
        }
        long start=System.nanoTime();
        mergesort(0,n-1);
        long end=System.nanoTime();
        System.out.println("Sorted Array is ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        System.out.println("Time Taken="+(end-start));
        sc.close();
    }
}
