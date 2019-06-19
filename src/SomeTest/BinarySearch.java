package SomeTest;

public class BinarySearch{
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		int a=15;
		int middle=arr.length/2;
		int left=arr[0];
		while(arr[middle]!=a){
			if(arr[middle]>a){
				left=arr[0];
				middle%=2;
			}
			if(arr[middle]<a){
				left=arr[middle];
				middle=(arr.length-middle)/2;
			}
		}
		System.out.println(middle);
	}
}