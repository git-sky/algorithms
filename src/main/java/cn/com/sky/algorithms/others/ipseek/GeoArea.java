package cn.com.sky.algorithms.others.ipseek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 根据查找距离该经纬度最近的城市
 */
public class GeoArea {

	// 数据文件
	private static final String DATA_FILE = "f:/geoarea.txt";
	// 赤道半径长度
	private static final double EARTH_RADIUS = 6378137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
	 * 
	 * @param lng1
	 * @param lat1
	 * @param lng2
	 * @param lat2
	 * @return
	 */
	public static double getDistance(double lng1, double lat1, double lng2,
			double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	/**
	 * 返回距离该经纬度最近的城市（地级市）
	 * 
	 * @param lng1 经度
	 * @param lat2 纬度
	 * @param map
	 * @return
	 */
	public static String getNearestCity(double lng, double lat) {
		
		//数据源
		Map<String, String> map = getTable();

		// 距离-城市
		Map<Long, String> min_map = new HashMap<Long, String>();

		Set<String> map_key = map.keySet();
		for (Iterator<String> it = map_key.iterator(); it.hasNext();) {
			String pos = (String) it.next();
			String city = map.get(pos);
			String[] arr = pos.split(",");
			// 经度
			double longitude = Double.valueOf(arr[0]);
			// 纬度
			double latitude = Double.valueOf(arr[1]);

			double distance = getDistance(lng, lat, longitude, latitude);
			//System.out.println("Distance=" + distance);
			Long d = Math.round(distance * 10000) / 10000;
			min_map.put(d, city);
			System.out.println(d+"," + city);
			
		}

		Set<Long> min_key = min_map.keySet();
		long min = 0;
		for (Iterator<Long> it = min_key.iterator(); it.hasNext();) {
			long l = (long) it.next();
			if (min > l) {
				min = l;
			} else if (min == 0) {
				min = l;
			}
		}
		return min_map.get(min);
	}

	public static Map<String, String> getTable() {

		Map<String, String> m = new HashMap<String, String>();

		BufferedReader br;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File(DATA_FILE))));
			while ((str = br.readLine()) != null) {
//				System.out.println("str=" + str);
				String arr[] = str.split(",");
				System.out.println("str=" + arr[0]);
				System.out.println("str=" + arr[1]);
				System.out.println("str=" + arr[2]);
				System.out.println("str=" + arr[3]);
				System.out.println("str=" + arr[4]);
				String key = arr[3] + "," + arr[4];
				String value = arr[0] + "," + arr[1];
				m.put(key, value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return m;

	}

	public static void main(String[] args) {
		
//		double lng = Double.valueOf(args[0]);
//		double lat = Double.valueOf(args[1]);
		
		double lng = Double.valueOf("115.32");
		double lat = Double.valueOf(33.23);

		String pos = getNearestCity(lng, lat);
		System.out.println("city=" + pos);
	}

}