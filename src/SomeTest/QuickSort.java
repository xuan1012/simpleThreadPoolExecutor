package SomeTest;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] data = { 1, 44, 38, 5, 47, 15, 36, 26, 27, 2, 26, 4, 19, 50, 47 };
		quickSort(data, 0, data.length - 1);
	}

	public static void quickSort(int[] a, int low, int high) {
		System.out.println("开始快速排序：" + Arrays.toString(a) + "low=" + low + "high=" + high);
		// 起始位置
		int start = low;
		// 结束位置
		int end = high;
		// 基准
		int key = a[low];
		System.out.println(Arrays.toString(a));
		while (end > start) {
			while (end > start && a[end] >= key) {
				end--;
			}
			if (a[end] < key) {
				System.out.println(a[end] + "<" + key + "交换");
				// 交换
				int tmp = a[end];
				a[end] = a[start];
				a[start] = tmp;
				System.out.println("\t" + Arrays.toString(a));
			}
			while (end > start && a[start] <= key) {
				start++;
			}
			if (a[start] > key) {
				System.out.println(a[start] + ">" + key + "交换");
				int tmp = a[start];
				a[start] = a[end];
				a[end] = tmp;
				System.out.println("\t" + Arrays.toString(a));
			}
		}
		if (start > low) {
			quickSort(a, low, start - 1);
		}
		if (end < high) {
			quickSort(a, end + 1, high);
		}

	}
}
