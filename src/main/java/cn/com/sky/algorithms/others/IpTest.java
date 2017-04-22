package cn.com.sky.algorithms.others;

public class IpTest {

	public static void main(String args[]) {
		String ipAddress="192.168.1.1";
		long ip=new IpTest().ipToInt(ipAddress);
		System.out.println("你"+ip+"好");
	}

	private long ipToInt(String ip) {
		String[] arr = ip.split("\\.");
		//System.out.println("你"+arr.length+"好");
		long ret = 0;
		for (int i = 0; i < arr.length; i++) {
			long l = 1;
			for (int j = 0; j < i; j++) {
				l *= 256;
			}
			try {
				ret += Long.parseLong(arr[arr.length - i - 1]) * l;
				//System.out.println("你ret="+ret+"好");
			} catch (Exception e) {
				ret += 0;
			}
		}
		return ret;
	}

}
