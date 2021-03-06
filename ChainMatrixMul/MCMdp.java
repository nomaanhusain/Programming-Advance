import java.util.Arrays;

public class MCMdp {
    static int t[][]=new int[1001][1001];
    static int solve(int arr[],int i,int j){
        if(i>=j){
            return 0;
        }
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solve(arr,i,k)+solve(arr, k+1, j)+(arr[i-1]*arr[k]*arr[j]);
           
            if(temp<min){
                min=temp;
            }
        }
        t[i][j]=min;
        return t[i][j];
    }
    public static void main(String[] args) {
        for(int[] ar:t){
        Arrays.fill(ar, -1);}
        int dimension[]=new int[]{4,3,2}; //this is 2 arrays, one of dimension (40x30) and one of (30x10)
        System.out.println(solve(dimension, 1, (dimension.length)-1));
    }
}