package MyThread.ThreadExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadPoolExecutor {
	private List<WorkThread> threads;
	private int relaxThread;
	WorkThread executor;
	List<Runnable> waitrunnable = new ArrayList<>();

	public ThreadPoolExecutor(int threadCount) {
		executor = new WorkThread();
		executor.start();
		threads = Collections.synchronizedList(new ArrayList<WorkThread>());
		relaxThread = threadCount;
		for (int i = 0; i < threadCount; i++) {
			WorkThread thread = new WorkThread();
			threads.add(thread);
			thread.start();
		}
	}

	public void execute(Runnable runnable) {
		int i = 0;
		synchronized (this) {
			for (i = 0; i < threads.size(); i++) {
				if (!threads.get(i).getIsRunning()) {
					threads.get(i).setRunnable(runnable);
					System.out.println("线程" + threads.get(i).getName());
					relaxThread--;
					break;
				}
			}
		}
		if (i >= threads.size()) {
			waitrunnable.add(runnable);
			if (!executor.getIsRunning()) {
				executor.setRunnable(() -> {
					System.out.println("创建了排队线程");
					boolean isRelax = false;
					int j = 0;
					while (true) {
						for (int x = 0; x < threads.size(); x++) {
							if (!threads.get(x).getIsRunning()) {
								relaxThread++;
							}
						}
						if (relaxThread > 0) {
							if (waitrunnable.size() > 0) {
								execute(waitrunnable.get(j));
								waitrunnable.remove(j);

							} else {
								break;
							}
						} else {
							try {
								executor.sleep(3000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
				});
			}
		}
	}
}
