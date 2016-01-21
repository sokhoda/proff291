package Base25.week6.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class MyScannerStr {
	private Reader				reader;
	private char				delimiter;
	private BufferedReader		br;
	private boolean				closed;
	private String				str;
	private int					pos;
	private ArrayList<String>	buf	= new ArrayList<String>();

	public MyScannerStr(Reader reader) {
		this.reader = reader;
		this.delimiter = ' ';
		this.pos = 0;
		this.closed = false;
		this.br = new BufferedReader(reader);
		try {
			this.str = br.readLine();
			if (str.length() > 0) {
				String[] arr = str.split(Character.toString(delimiter));
				for (String string : arr) {
					buf.add(string);
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	};

	public MyScannerStr(String str) {
		this.str = str;
		this.delimiter = ' ';
		this.pos = 0;
		this.closed = false;
		if (str.length() > 0) {
			String[] arr = str.split(Character.toString(delimiter));
			for (String string : arr) {
				buf.add(string);
			}
		}

	};

	public void close() {
		this.closed = true;
	}

	public boolean hasNext() {
		if (closed) throw new IllegalStateException();
		if (buf.size() == 0 || pos >= buf.size()) {
			return false;
		}
		else return true;
	}

	public boolean hasNextInt() {
		if (closed) throw new IllegalStateException();
		if (buf.size() == 0 || pos >= buf.size()) {
			return false;
		}
		else {
			try {
				Integer.parseInt(buf.get(pos));
				return true;
			}
			catch (NumberFormatException e) {
				return false;
			}

		}
	}

	public String next() {
		if (closed) throw new IllegalStateException();
		if (buf.size() > 0) {
			if (pos < buf.size()) {
				return buf.get(pos++);
			}
			else throw new NoSuchElementException();

		}
		else throw new NoSuchElementException();
	}

	public int nextInt() throws InputMismatchException {
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
			else throw new NoSuchElementException();
		}
		else throw new NoSuchElementException();

	}

	public void useDelimiter(char delimiter) {
		if (closed) throw new IllegalStateException();
		this.delimiter = delimiter;
		buf.clear();
		if (str.length() > 0) {
			String[] arr = str.split(Character.toString(delimiter));
			for (String string : arr) {
				buf.add(string);
			}
		}
		pos = 0;
	}

	public String nextLine() {
		if (closed) throw new IllegalStateException();
		if (str.length() > 0 && pos <= buf.size()) {
			pos = buf.size() + 1;
			return str;
		}
		else throw new NoSuchElementException();
	}

}
