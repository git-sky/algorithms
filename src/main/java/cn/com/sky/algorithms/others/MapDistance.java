package cn.com.sky.algorithms.others;
public class MapDistance {

	private static final double EARTH_RADIUS = 6378137;

	private static double rad(double d) {

		return d * Math.PI / 180.0;

	}

	public static double getDistance(double lat1, double lng1, double lat2,
			double lng2) {

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
	
	public static void main(String args[]){
		
		double lng1=115.68;
		double lat1=37.73;

		double lng2=114.93;
		double lat2=25.87;


		
		double distance=getDistance(lat1, lng1, lat2, lng2);
		
		System.out.println(distance);
	}

}
