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
		System.out.println("��²¿�ѽ~~~  ��/����");
		Scanner sc = new Scanner(System.in);
		boolean in = sc.next().equals("��") ? true : false;

		if (this.is24(4)) {
			System.out.println(result[0] + "=24");
			if (in) {
				System.out.println("����ˣ�����ؼ����");
			} else {
				System.out.println("����ؼ��");
			}
		} else {
			System.out.println("������");
			if (in) {
				System.out.println("����ؼ��");
			} else {
				System.out.println("����ˣ�����ؼ����");
			}
		}

	}

	private boolean is24(int n) {
		if (n == 1) {
			return (Math.abs(poker[0] - 24) < error); // �ж����
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {// ������������㷨������
				double a, b;
				String stra, strb;
				a = poker[i];
				b = poker[j];
				stra = result[i];
				strb = result[j];// ����ǰ������Ԫ�ء�

				poker[j] = poker[n - 1];// �����һ��Ԫ���Ƶ��ڶ���
				result[j] = result[n - 1];

				result[i] = "(" + stra + "+" + strb + ")";// ���Լӷ�
				poker[i] = a + b;
				if (is24(n - 1)) {
					return true;
				}
				result[i] = "(" + stra + "-" + strb + ")";// ���Լ���
				poker[i] = a - b;
				if (is24(n - 1)) {
					return true;
				}
				result[i] = "(" + strb + "-" + stra + ")";
				poker[i] = b - a;
				if (is24(n - 1)) {
					return true;
				}
				result[i] = "(" + stra + "��" + strb + ")";// ���Գ˷�
				poker[i] = a * b;
				if (is24(n - 1)) {
					return true;
				}
				if (b != 0) {
					result[i] = "(" + stra + "��" + strb + ")";// ���Գ���
					poker[i] = a / b;
					if (is24(n - 1)) {
						return true;
					}
				}

				if (a != 0) {
					result[i] = "(" + strb + "��" + stra + ")";
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
