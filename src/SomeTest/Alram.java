package SomeTest;

interface Alram {
	void alarm();
}

abstract class Door {
	abstract void open();

	abstract void close();
}

class AlarmDoor extends Door implements Alram {
	void open() {
		// ....
	}

	void close() {
		// ....
	}

	public void alarm() {
      //....
    }
}