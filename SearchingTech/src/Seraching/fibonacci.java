package Seraching;

public class fibonacci {
	    	    static int fibonacciSearch(int[] arr, int target) {
	        int n = arr.length;
	        int fib2 = 0; 
	        int fib1 = 1; 
	        int fib = fib2 + fib1; 
	        while (fib < n) {
	            fib2 = fib1;
	            fib1 = fib;
	            fib = fib2 + fib1;
	        }
	        int offset = -1;
	        while (fib > 1) {
	            int i = Math.min(offset + fib2, n - 1);
	            if (arr[i] < target) {
	                fib = fib1;
	                fib1 = fib2;
	                fib2 = fib - fib1;
	                offset = i;
	            }
	            else if (arr[i] > target) {
	                fib = fib2;
	                fib1 = fib1 - fib2;
	                fib2 = fib - fib1;
	            }
	            else {
	                return i;
	            }
	        }
	        if (fib1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
	            return offset + 1;
	        }

	        return -1;
	    }

	    public static void main(String[] args) {
	        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
	        int target = 85;
	        System.out.println(fibonacciSearch(arr, target)); // Output: 8
	    }
	}

