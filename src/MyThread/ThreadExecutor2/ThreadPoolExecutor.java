package MyThread.ThreadExecutor2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadPoolExecutor {
	private List<WorkThread> threads;
	private int relaxThread;
	WorkThread executor;
	List<Runnable> waitrunnable = new ArrayList<>();
	Object obj = new Object();

	public ThreadPoolExecutor(int threadCount) {
		executor = new WorkThread();
		executor.start();
		threads = Collections.synchronizedList(new ArrayList<WorkThread>());
		relaxThread = threadCount;
		for (int i = 0; i < threadCount; i++) {
			WorkThread thread = new WorkThread();
			threads.add(thread);
			thread.start();
			if (!executor.getIsRunning()) {
				executor.setRunnable(() -> {
					System.out.println("创建了排队线程");
					boolean isRelax = false;
					int j = 0;
					synchronized (executor) {

						try {
							executor.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}

						while (true) {
							int y = 0;
							for (int x = 0; x < threads.size(); x++) {
								if (!threads.get(x).getIsRunning()) {
									y++;
									relaxThread = y;
								}
							}
							if (relaxThread > 0) {
								if (waitrunnable.size() > 0) {
									execute(waitrunnable.get(j));
									waitrunnable.remove(j);
								}
							} else {
								try {
									System.out.println("我睡了");

									executor.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}

					}
				}, executor);
			}
		}
	}

	public void execute(Runnable runnable) {
		int i = 0;
		synchronized (this) {
			for (i = 0; i < threads.size(); i++) {
				if (!threads.get(i).getIsRunning()) {
					threads.get(i).setRunnable(runnable, executor);
					System.out.println("线程" + threads.get(i).getName());
					relaxThread--;
					break;
				}
			}
		}
		if (i >= threads.size()) {
			System.out.println("加入了");
			waitrunnable.add(runnable);

		}
	}
}
