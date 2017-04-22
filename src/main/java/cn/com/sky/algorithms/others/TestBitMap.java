package cn.com.sky.algorithms.others;

import java.util.BitSet;
import java.util.TreeSet;

public class TestBitMap {
	public static void main(String[] args) {
		
		TreeSet set = new TreeSet();
		
		for (long i = 10000000000L; i < 900000000000L; i++) {
			set.add(i);
			System.out.println("i=" + i);
		}

		for (long i = 10000000000L; i < 900000000000L; i++) {
			set.add(i + "");
			System.out.println("i=" + i);
		}
		
		BitSet bitSet = new BitSet(100);
		bitSet.set(1, true);
		bitSet.set(3, true);
		bitSet.set(6, true);
		bitSet.set(100, true);
		for (int i = 0; i < bitSet.size(); i++) {
			boolean b = bitSet.get(i);
			if (b) {
				System.out.println(i);
			}
		}
	}
}
