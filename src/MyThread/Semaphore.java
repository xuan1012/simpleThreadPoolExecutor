package MyThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Semaphore {
	private List<Object> locks = Collections.synchronizedList(new ArrayList<Object>());
	private int permitNum = 1;
	private int nowPermitNum = 1;// 当前的许可数量
	private boolean permitNumGrow = false;
	private boolean fair = false;
	Random random = new Random();

	public Semaphore(int permitNum, boolean permitNumGrow, boolean fair) {
		this.fair = fair;
		this.permitNum = permitNum;
		this.nowPermitNum = permitNum;
		this.permitNumGrow = permitNumGrow;
	}

	public Semaphore(int permitNum) {
		this(permitNum, true, false);
	}

	public Semaphore() {
		this(1);
	}

	public void acquire() {
		Object lock = new Object();
		synchronized (lock) {
			if (nowPermitNum > 0) {
				nowPermitNum--;
			} else {
				locks.add(lock);
				try {
					lock.wait();// 没有许可就等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void release() {
		if (locks.size() > 0) {
			int index = 0;
			if (!fair) {
				index = Math.abs(random.nextInt()) % locks.size();
			}
			Object lock = locks.get(index);
			locks.remove(lock);
			synchronized (lock) {
				lock.notify();// 唤醒一个等待的线程
			}
		} else if (nowPermitNum < permitNum || permitNumGrow) {
			nowPermitNum++;
		}
	}

	public int getAvailablePermitNum() {
		return nowPermitNum;
	}

}
