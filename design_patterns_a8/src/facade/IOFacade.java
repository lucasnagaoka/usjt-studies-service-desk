package facade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IOFacade {
	private String str;
	private FileInputStream inStream;
	private ObjectInputStream inObjectStream;

	public void readText(File inFile) throws IOException {
		FileReader fileReader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(fileReader);

		this.str = bufReader.readLine();
		int i = Integer.parseInt(this.str);

		this.str = bufReader.readLine();
		long l = Long.parseLong(this.str);

		this.str = bufReader.readLine();
		float f = Float.parseFloat(this.str);

		this.str = bufReader.readLine();
		double d = Double.parseDouble(this.str);

		this.str = bufReader.readLine();
		char c = this.str.charAt(0);

		this.str = bufReader.readLine();
		Boolean boolObj = new Boolean(str);
		boolean b = boolObj.booleanValue();
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(c);
		System.out.println(b);

		bufReader.close();
	}

	public void readBin(File inFile) throws IOException {
		inStream = new FileInputStream(inFile);

		int fileSize = (int) inFile.length();
		byte[] byteArray = new byte[fileSize];

		inStream.read(byteArray);
		for (int i = 0; i < fileSize; i++) {
			System.out.println(byteArray[i]);
		}

		inStream.close();
	}

	public void readObject(File inFile) throws IOException, ClassNotFoundException {
		FileInputStream inFileStream = new FileInputStream(inFile);
		inObjectStream = new ObjectInputStream(inFileStream);

		Pessoa pessoa;
		for (int i = 0; i < 10; i++) {
			pessoa = (Pessoa) inObjectStream.readObject();
			System.out.println(pessoa.getNome() + " " + pessoa.getIdade() + " " + pessoa.getGenero());
		}

		inObjectStream.close();
	}
}
