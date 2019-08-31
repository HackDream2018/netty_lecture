package test.weatherapi;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/28
 */
public class HttpUtils {

    public static void main(String[] args) {
        final String BONUS_SYS_IP_ADDRESS = "192.168.100.68:18099";
        /*// post案例
        String body = String.format("{\"campaignId\":\"%s\",\"campaignKind\":\"%s\",\"orgCode\":\"%s\"," +
                        "\"startDate\":\"%s\",\"endDate\":\"%s\",\"planId\":\"%s\"," +
                        "\"customerId\":\"%s\",\"cardNo\":\"%s\",\"pageNum\":\"%s\"," +
                        "\"pageSize\":\"%s\"}",
                "00000010550220190823",
                "1",
                "0461",
                "20190827",
                "20190827",
                "107504",
                "430102198801100664",
                "",
                "1",
                "20");
        String postURL = String.format("http://%s/clm/calcErrLog/queryCalcErrLogs", BONUS_SYS_IP_ADDRESS);
        String postResponse = doPost(postURL, body);*/

        // get案例
        String getURL = String.format("http://%s/elasticsearch/index/getClientSearcherInfo", BONUS_SYS_IP_ADDRESS);
        String getResponse = doGet(getURL);
    }

    /**
     * get请求
     * @param url url地址
     */
    public static String doGet(String url){
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        HttpURLConnection connection = null;
        try {
            URL getUrl = new URL(url);
            connection = (HttpURLConnection) getUrl.openConnection();

            connection.connect();// 连接会话

            // 获取输入流
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (br != null) {
                    br.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (IOException e) {}
        }
        return sb.toString();
    }

    /**
     * post请求
     * @param url url地址
     * @param params 请求参数
     */
    public static String doPost(String url,String params) {
        return doPost(url, params, "application/json;charset=UTF-8");
    }

    /**
     * post请求
     * @param urlPath url地址
     * @param params 请求参数
     * @param contentType HttpURLConnection的contentType属性值，例如：application/json或者text/html等
     */
    public static String doPost(String urlPath,String params, String contentType) {
        StringBuffer buffer = new StringBuffer();
        PrintWriter out = null;
        InputStream input = null;
        BufferedReader br = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("content-Type", contentType);
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("appId", "cms");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter(conn.getOutputStream());
            out.print(params);
            out.flush();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                // 作用: Socket空闲时才断开, 如果有线程在访问TCP链路就不断卡
                if(null != conn) {
                    conn.disconnect();
                }
                if(null != out) {
                    out.close();
                }
                if(null != input) {
                    input.close();
                }
                if(null != br) {
                    br.close();
                }
            }catch (Exception e2) {}

        }
        return buffer.toString();
    }

}

