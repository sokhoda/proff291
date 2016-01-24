package Base25.week6.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MyScanner {
	private Reader				reader;
	private char				delimiter;
	private BufferedReader		br;
	private boolean				closed;
	private int					pos;
	private ArrayList<String>	buf	= new ArrayList<String>();

	public MyScanner(Reader reader) {
		this.reader = reader;
		this.delimiter = ' ';
		this.pos = 0;
		this.closed = false;
		this.br = new BufferedReader(reader);

	};

	public void close() {
		this.closed = true;
	}

	public boolean hasNext() {
		if (closed) throw new IllegalStateException();
		String str;
		if (buf.size() == 0 || pos >= buf.size()) {

			try {
				str = br.readLine();
				String[] arr = str.split(Character.toString(delimiter));
				buf.clear();
				for (String string : arr) {
					buf.add(string);
				}
				pos = 0;
			}
			catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean hasNextInt() {
		if (closed) throw new IllegalStateException();
		String str;
		if (buf.size() == 0 || pos >= buf.size()) {

			try {
				str = br.readLine();
				String[] arr = str.split(Character.toString(delimiter));
				buf.clear();
				for (String string : arr) {
					try {
						Integer.parseInt(string);
					}
					catch (NumberFormatException e) {
						throw new InputMismatchException();
					}
					buf.add(string);
				}
				pos = 0;
			}
			catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public int nextInt() throws InputMismatchException {
		String str;
		if (closed) throw new IllegalStateException();

		if (buf.size() > 0) {
			if (pos < buf.size()) {
				try {
					return Integer.parseInt(buf.get(pos++));
				}
				catch (NumberFormatException e) {
					throw new InputMismatchException();
				}
			}
			else {

				try {
					str = br.readLine();
					String[] arr = str.split(Character.toString(delimiter));
					for (String string : arr) {
						buf.add(string);
					}
					try {
						return Integer.parseInt(buf.get(pos++));
					}
					catch (NumberFormatException e) {
						throw new InputMismatchException();
					}
				}
				catch (IOException e) {
					e.printStackTrace();
					return 0;
				}

				// throw new NoSuchElementException();
			}
		}
		else {
			try {
				str = br.readLine();
				String[] arr = str.split(Character.toString(delimiter));
				buf.clear();
				for (String string : arr) {
					buf.add(string);
				}
				pos = 0;
				try {
					return Integer.parseInt(buf.get(pos++));
				}
				catch (NumberFormatException e) {
					throw new InputMismatchException();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
		}

	}

	public void useDelimiter(char delimiter) {
		if (closed) throw new IllegalStateException();
		this.delimiter = delimiter;
	}

	public String next() {
		String str;
		if (closed) throw new IllegalStateException();
		if (buf.size() > 0) {
			if (pos < buf.size()) {
				return buf.get(pos++);
			}
			else {
				try {
					str = br.readLine();
					String[] arr = str.split(Character.toString(delimiter));
					for (String string : arr) {
						buf.add(string);
					}
					return buf.get(pos++);
				}
				catch (IOException e) {
					e.printStackTrace();
					return "";
				}
			}

			// throw new NoSuchElementException();
		}
		else {
			try {
				str = br.readLine();
				String[] arr = str.split(Character.toString(delimiter));
				buf.clear();
				for (String string : arr) {
					buf.add(string);
				}
				pos = 0;
				return buf.get(pos++);
			}
			catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
	}

	public String nextLine() {
		if (closed) throw new IllegalStateException();
		try {
			return br.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
