package cn.com.sky.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractSort implements Sortable {

	static Random random = new Random();

	static int size = 11;

	static int[] array = new int[size];

	static int max = 100;

	@BeforeClass
	public static void setUpBeforeClass() {
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(max);
		}

	}

	@AfterClass
	public static void tearDownAfterClass() {

	}

	protected int count = 0;
	protected int n = 0;

	protected String methodName = "";

	protected int[] arr = new int[size];
	protected int[] arr_sorted = new int[size];

	@Before
	public void setUp() {

		arr = array.clone();

		arr_sorted = array.clone();

		Arrays.sort(arr_sorted);

		// arr = new int[] { 2, 3, 4, 5, 6, 1 };

		System.out.println(Arrays.toString(arr));

		// Assert.assertArrayEquals(arr, arr_sorted);

		count = 0;
		methodName = "";
		n = arr.length;
		System.out.println("count=" + count);
		System.out.println("n=" + n);
		System.out.println("methodName=" + methodName);

	}

	@After
	public void tearDown() {
		System.out.println(Arrays.toString(arr));
		System.out.println("count=" + count);
		System.out.println("n=" + n);
		System.out.println("methodName=" + methodName);
		System.out.println("=======================================================");

		Assert.assertArrayEquals(arr, arr_sorted);
	}

	public abstract void sort();

}