package Base25.week6.lesson12;

public class Task2Thread extends Thread {
	private String	nameTh;

	public String getnameTh() {
		return nameTh;
	}

	public void setnameTh(String nameTh) {
		this.nameTh = nameTh;
	}

	public Task2Thread(String nameTh) {
		this.nameTh = nameTh;
	}

	@Override
	public void run() {
		System.out.println(getName() + " начал работу. Спасибо.");
		while (true) {
			if (isInterrupted()) {
				System.out.println(getName() + " завершил работу. Спасибо.");
				return;
			}
		}
	}

}
