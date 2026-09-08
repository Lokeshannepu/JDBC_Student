package Seraching;

public class lowerbound {
		static int lowerBound(int[] arr,int target) {
			int left=0;
			int right=arr.length;
			while(left<right) {
				int mid=left+(right-left)/2;
				if(arr[mid]>=target) {
					right=mid;
				}else {
					left=mid+1;
				}
			}
			return left;
		}
		public static void main(String[] args) {
			int[] arr= {10,20,40,50,80,60};
			int target=50;
			int index=lowerBound(arr,target);
			System.out.println("Lower bound : "+index);
		}
}
//  