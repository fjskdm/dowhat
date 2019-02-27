package com.example.lenovo.hello.MySQLUse;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SQLUtil{


    public static Connection openConnection(String url, String user, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            conn = null;
            Log.d("warning:", "openConnection:失败1 ");
            e.printStackTrace();
        } catch (SQLException e) {
            conn = null;
            Log.d("warning:", "openConnection:失败2 ");
            e.printStackTrace();
        }
        Log.d("success:", "连接成功");
        return conn;
    }

    public static void creatNew(Connection conn,String name,String pass){
        PreparedStatement pre = null;
        int i;
        try{
            pre = conn.prepareStatement("insert into do(name,password) values(?,?)");
            pre.setString(1,name);
            pre.setString(2,pass);
            i = pre.executeUpdate();
            Log.e("状态码：","运行的结果是"+i);
        }
        catch (SQLException e){
            Log.e("创建错误","错误："+e);
        }
        finally {
            try {
                if (pre != null) pre.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }

    }

    public static ArrayList query(Connection conn, String sql) {

        ArrayList<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
        if (conn == null) {
            return null;
        }

        Statement statement = null;
        ResultSet result = null;
        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            if (result != null && result.first()) {
                int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("name");
                System.out.println("id\t\t" + "name");
                while (!result.isAfterLast()) {
                    Map<String,String> map = new HashMap<String, String>();
                    map.put("id",result.getString(idColumnIndex).toString());
                    map.put("name",result.getString(nameColumnIndex).toString());
                    System.out.print(result.getString(idColumnIndex) + "\t\t");
                    System.out.println(result.getString(nameColumnIndex));
                    resultList.add(map);
                    result.next();
                }
            }
        } catch (SQLException e) {
            Log.e("error:","查询错误");
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }

            } catch (SQLException sqle) {

            }
        }
        return resultList;
    }

    public static boolean execSQL(Connection conn, String sql) {
        boolean execResult = false;
        if (conn == null) {
            return execResult;
        }

        Statement statement = null;

        try {
            statement = conn.createStatement();
            if (statement != null) {
                execResult = statement.execute(sql);
            }
        } catch (SQLException e) {
            execResult = false;
            Log.d("warning:", "openConnection:失败3 ");
        }

        return execResult;
    }
}
