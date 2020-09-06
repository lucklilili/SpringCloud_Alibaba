/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/9/1 2:59 下午
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class DBHelper {

    public static void conn() throws Exception{
        String URL = "jdbc:mysql://127.0.0.1:3306/map?characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "root";
        // 1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得数据库链接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM CRM_REGION limit 26963,43184";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            String region_code = "",county_location = "" ,town_location ="",location = "";
            while (rs.next()) {
                region_code =rs.getString("REGION_CODE");
                county_location = callGDDT(rs.getString("CITY")+rs.getString("COUNTY"));
                town_location= callGDDT(rs.getString("COUNTY")+rs.getString("TOWN"));
                if(town_location != null){
                    location =PointDistanceApi.getLatLngDistance(
                            Double.parseDouble(county_location.split(",")[0]),
                            Double.parseDouble(county_location.split(",")[1]),
                            Double.parseDouble(town_location.split(",")[0]),
                            Double.parseDouble(town_location.split(",")[1]),
                            true
                    );
                }
                upd(region_code,county_location,town_location,location);
            }

            // 关闭资源
            conn.close();
            rs.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void upd(String region_code,String county_location,String town_location,String location) throws Exception{
        String URL = "jdbc:mysql://127.0.0.1:3306/map?characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "root";
        // 1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得数据库链接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "UPDATE CRM_REGION SET COUNTY_LOCATION = ?,TOWN_LOCATION = ?,COUNTY_TO_TOWN_LOCATION = ? WHERE  REGION_CODE=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,county_location);
            statement.setString(2,town_location);
            statement.setString(3,location);
            statement.setString(4,region_code);
            statement.execute();
            conn.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private static String callGDDT(String data) throws Exception{
        String str = null;

        String urlNameString = "https://restapi.amap.com/v3/geocode/geo?key=dc9061039fdff8697612e45d136f4b34&address="+ data;
        JSONObject jsonObject = JSONObject.parseObject(HttpRequest.AccountCenter(urlNameString));
        if(jsonObject.getString("infocode").equals("10000")){
            System.out.println(jsonObject);
            JSONArray geocodes =  jsonObject.getJSONArray("geocodes");
            if(geocodes.size() > 0){
                str = geocodes.getJSONObject(0).get("location").toString();

            }

        }
        return str;

    }

    public static void main(String[] args)throws Exception {
        conn();


    }





}
