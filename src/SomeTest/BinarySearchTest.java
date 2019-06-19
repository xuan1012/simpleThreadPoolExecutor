package SomeTest;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		int a=15;
		int right=arr.length-1;
		int middle=0;
		int left=0;
		while(true){
			middle=(left+right)/2;
//			System.out.println(middle);
			if(arr[middle]>a){
				right=middle-1;
				middle%=2;
			}
			if(arr[middle]<a){
				left=middle+1;
//				middle=(arr.length-middle)/2;
			}
			if(arr[middle]==a) {
				System.out.println(middle);
				break;
			}
		}
	}
}
