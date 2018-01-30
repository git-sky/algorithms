package cn.com.sky.algorithms.interview;

public class PrintStar {
	
	
	public static void main(String[] args) {
		
		int N=2;
		String x="*";
		for(int i=0;i<2*N-1;i++){
			for(int j=0;j<2*N-1;j++){
				System.out.print(x);
			}
			System.out.println();
		}
		
	}

}
