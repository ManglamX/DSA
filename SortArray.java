//{ Driver Code Starts
import java.io.*;
import java.util.*;

class SortArray{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid] only when they are different
                if (low != mid) {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                }
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Move mid for 1 without swapping
                mid++;
            } else { // arr[mid] == 2
                // Swap arr[mid] and arr[high] only when they are different
                if (mid != high) {
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                }
                high--;
            }
        }
    }
}