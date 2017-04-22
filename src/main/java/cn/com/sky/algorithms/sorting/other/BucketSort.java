package cn.com.sky.algorithms.sorting.other;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * <pre>
 * 
 * 桶排序算法
 * 
 *  对N个关键字进行桶排序的时间复杂度分为两个部分：
 * 
 * (1) 循环计算每个关键字的桶映射函数，这个时间复杂度是O(N)。
 * 
 * (2) 利用先进的比较排序算法对每个桶内的所有数据进行排序，其时间复杂度为  ∑ O(Ni*logNi) 。其中Ni 为第i个桶的数据量。
 * 
 * 很显然，第(2)部分是桶排序性能好坏的决定因素。尽量减少桶内数据的数量是提高效率的唯一办法(因为基于比较排序的最好平均时间复杂度只能达到O(N*logN)了)。因此，我们需要尽量做到下面两点：
 * 
 * (1) 映射函数f(k)能够将N个数据平均的分配到M个桶中，这样每个桶就有[N/M]个数据量。
 * 
 * (2) 尽量的增大桶的数量。极限情况下每个桶只能得到一个数据，这样就完全避开了桶内数据的“比较”排序操作。当然，做到这一点很不容易，数据量巨大的情况下，f(k)函数会使得桶集合的数量巨大，空间浪费严重。这就是一个时间代价和空间代价的权衡问题了。
 * 
 * 对于N个待排数据，M个桶，平均每个桶[N/M]个数据的桶排序平均时间复杂度为：
 * 
 *    O(N)+O(M*(N/M)*log(N/M))=O(N+N*(logN-logM))=O(N+N*logN-N*logM)
 * 
 * 当N=M时，即极限情况下每个桶只有一个数据时。桶排序的最好效率能够达到O(N)。
 * 总结： 桶排序的平均时间复杂度为线性的O(N+C)，其中C=N*(logN-logM)。如果相对于同样的N，桶数量M越大，其效率越高，最好的时间复杂度达到O(N)。 当然桶排序的空间复杂度 为O(N+M)，如果输入数据非常庞大，而桶的数量也非常多，则空间代价无疑是昂贵的。此外，桶排序是稳定的。
 *
 *
 */
public class BucketSort {
	public static final int ARRAY_SIZE = 10000;
	public static final int BUCKET_SIZE = 10;

	public static void sort(int[] array) {
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < BUCKET_SIZE; i++) {
			bucket.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < array.length; i++) {
			int k = array[i] / 10;
			bucket.get(k).add(array[i]);
		}
		for (ArrayList<Integer> list : bucket)
			Collections.sort(list);
		for (ArrayList<Integer> list : bucket)
			System.out.println(list);
	}

	public static int[] init() {
		int[] array = new int[ARRAY_SIZE];
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("d:/score.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String string = new String();
		int i = 0;
		try {
			while ((string = br.readLine()) != null) {
				array[i] = Integer.valueOf(string);
				i++;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}

	public static void main(String[] argv) {

		int[] array = init();
		sort(array);

	}

}