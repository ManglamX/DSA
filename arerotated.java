//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class arerotated {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        String doubledS1 = s1 + s1; // Concatenated string

        // Using Rabin-Karp for substring search
        long targetHash = computeHash(s2);
        long currentHash = computeHash(doubledS1.substring(0, n));
        long power = 1;

        // Precomputing the power of the base (prime)
        for (int i = 0; i < n - 1; i++) {
            power = (power * 31) % 1_000_000_007;
        }

        // Sliding window
        for (int i = 0; i <= doubledS1.length() - n; i++) {
            if (currentHash == targetHash) {
                if (doubledS1.substring(i, i + n).equals(s2)) {
                    return true;
                }
            }
            // Update the hash for the next window
            if (i + n < doubledS1.length()) {
                currentHash = (currentHash - (doubledS1.charAt(i) - 'a' + 1) * power % 1_000_000_007 + 1_000_000_007) % 1_000_000_007;
                currentHash = (currentHash * 31 + (doubledS1.charAt(i + n) - 'a' + 1)) % 1_000_000_007;
            }
        }

        return false;
    }

    // Function to compute the hash of a string
    private static long computeHash(String s) {
        long hash = 0;
        long prime = 31;
        long mod = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            hash = (hash * prime + (s.charAt(i) - 'a' + 1)) % mod;
        }

        return hash;
    }
}