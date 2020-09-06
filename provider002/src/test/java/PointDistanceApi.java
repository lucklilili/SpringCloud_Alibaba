
import java.text.NumberFormat;

/**
 * 两点间距离API
 *
 */
public class PointDistanceApi {

    public static void main(String[] args) {
        double startLng = 116.368904;
        double startLat = 39.923423;
        double endLng = 116.387271;
        double endLat =  39.922501;
        String dis = getLatLngDistance(startLng, startLat, endLng, endLat, true);
        System.out.println("两点距离" + dis+"米");

    }

    /**
        * 计算两点之间距离
        * @param start
        * @param end
        * @return String  多少m ,  多少km
        */
    public static String getLatLngDistance(double startLng, double startLat, double endLng,
                                           double endLat, boolean ifUnit) {
        double lat1 = (Math.PI/180)* startLat;
        double lat2 = (Math.PI/180)* endLat;
        double lon1 = (Math.PI/180)* startLng;
        double lon2 = (Math.PI/180)* endLng;
        //TODO  赤道半径6378.004; 地球半径6371
        double R = 6378.004;
        double dis = Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1))*R;
        return Math.round(Math.floor(dis * 1000)) + "";
    }
}