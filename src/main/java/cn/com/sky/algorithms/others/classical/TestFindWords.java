package cn.com.sky.algorithms.others.classical;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;

public class TestFindWords {
	@Test
	public void findWords() throws FileNotFoundException {
		try {
			File file = new File("E://a.txt");

			if (file.exists()) {
				System.out.println("exists..");
			} else {
				System.out.println("not exists..........");
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };

			FileWriter fw = new FileWriter(file);
			for (int i = 0; i < 10000; i++) {
				Random r = new Random();
				int jj = r.nextInt(6);
				char aa = ch[jj];
				System.out.println(i);
				fw.write(aa + "\n");
			}

			FileReader fr = new FileReader("e://a.txt");
			fr.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
