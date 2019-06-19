package HomeWork0319;

import java.util.Random;
import java.util.Scanner;

public class PokerGame {
	private double[] poker = new double[4];
	private String[] result = new String[4];
	private static final double error = 1E-6;

	public void gameRun() {
		Random random = new Random();
		int tol = 0;
		int j = 0;
		while (tol < 4) {
			tol++;
			int i = random.nextInt(13) + 1;
			poker[j] = i;
			result[j] = i + "";
			System.out.print(poker[j] + "\t");
			j++;
		}
		System.out.println("你猜猜看呀~~~  能/不能");
		Scanner sc = new Scanner(System.in);
		boolean in = sc.next().equals("能") ? true : false;

		if (this.is24(4)) {
			System.out.println(result[0] + "=24");
			if (in) {
				System.out.println("答对了，你有丶东西");
			} else {
				System.out.println("你有丶蠢");
			}
		} else {
			System.out.println("不可以");
			if (in) {
				System.out.println("你有丶蠢");
			} else {
				System.out.println("答对了，你有丶东西");
			}
		}

	}

	private boolean is24(int n) {
		if (n == 1) {
			return (Math.abs(poker[0] - 24) < error); // 判断误差
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {// 遍历所有配对算法可能性
				double a, b;
				String stra, strb;
				a = poker[i];
				b = poker[j];
				stra = result[i];
				strb = result[j];// 储存前面两个元素。

				poker[j] = poker[n - 1];// 把最后一个元素移到第二个
				result[j] = result[n - 1];

				result[i] = "(" + stra + "+" + strb + ")";// 尝试加法
				poker[i] = a + b;
				if (is24(n - 1)) {
					return true;
				}
				result[i] = "(" + stra + "-" + strb + ")";// 尝试减法
				poker[i] = a - b;
				if (is24(n - 1)) {
					return true;
				}
				result[i] = "(" + strb + "-" + stra + ")";
				poker[i] = b - a;
				if (is24(n - 1)) {
					return true;
				}
				result[i] = "(" + stra + "×" + strb + ")";// 尝试乘法
				poker[i] = a * b;
				if (is24(n - 1)) {
					return true;
				}
				if (b != 0) {
					result[i] = "(" + stra + "÷" + strb + ")";// 尝试除法
					poker[i] = a / b;
					if (is24(n - 1)) {
						return true;
					}
				}

				if (a != 0) {
					result[i] = "(" + strb + "÷" + stra + ")";
					poker[i] = b / a;
					if (is24(n - 1)) {
						return true;
					}
				}

				poker[i] = a;
				poker[j] = b;
				result[i] = stra;
				result[j] = strb;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		PokerGame pg = new PokerGame();
		pg.gameRun();
	}
}
