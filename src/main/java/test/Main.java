package test;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pro on 17/1/3.
 */
public class Main {
    public static void main(String[] args) {

//        URL url = null;
//        String line;
//        try {
//            url = new URL("http://jwxt.xidian.edu.cn/");
//
////            url = new URL("http://jwxt.xidian.edu.cn/caslogin.jsp");
//            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//            InputStreamReader ireader = new InputStreamReader(httpConn.getInputStream(), "UTF-8");
//            BufferedReader bufferReader = new BufferedReader(ireader);
//            while((line=bufferReader.readLine())!=null) {
//                System.out.println(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Map<String,String> params=new HashMap<String,String>();
        params.put("username","14130130279");
        params.put("password","240010");
        params.put("_eventId","submit");
        params.put("rmShown","1");

//        String info=doPost("http://jwxt.xidian.edu.cn/authserver/login",params);
        String info=login("http://ids.xidian.edu.cn/authserver/login?service=http%3A%2F%2Fyjsxt.xidian.edu.cn%2Flogin.jsp",null);
//        System.out.println(info);
    }

    public static String login(String url,Map<String,String> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response=null;
        String info=null;
        try {
            HttpGet get = new HttpGet(url);
            response=httpClient.execute(get);
            //获取网页源码
            HttpEntity enitty = response.getEntity();
            //将内容转码
            info = new String (EntityUtils.toString(enitty).getBytes("iso-8859-1"),"utf-8");
            //获取cookie
            Header headers[] = response.getHeaders("Set-Cookie");
            {
                System.out.println("-------------------------------------");
                for (Header h:response.getAllHeaders()){
                    System.out.println(h.toString());
                }
                System.out.println("-------------------------------------");
            }
            //获取sessionId
            String jsessionId=null;
            for(Header h:headers){
                String value=h.getValue();
                if(value.contains("JSESSIONID")) {
                    jsessionId = value.substring(11, value.indexOf(";"));
                    System.out.println(jsessionId);
                }
            }
            //获取隐藏域
            //lt
            int ltIndex=info.indexOf("LT-");
            String nameLt=info.substring(ltIndex,ltIndex+62);
            System.out.println("lt------"+nameLt);
            //execution
            int exIndex=info.indexOf("execution")+18;
            String executionName=info.substring(exIndex,exIndex+4);
            System.out.println("execution++++++"+executionName);

            //用于构建参数列表
            HttpPost post=new HttpPost("http://ids.xidian.edu.cn/authserver/login?service=http%3A%2F%2Fyjsxt.xidian.edu.cn%2Flogin.jsp");
            List<BasicNameValuePair> paramsList=new ArrayList<BasicNameValuePair>();
            if(params!=null){
                for(String key:params.keySet())
                    paramsList.add(new BasicNameValuePair(key,params.get(key)));
                paramsList.add(new BasicNameValuePair("lt",nameLt));
                paramsList.add(new BasicNameValuePair("execution",executionName));
                UrlEncodedFormEntity en=new UrlEncodedFormEntity(paramsList);
                post.setEntity(en);
            }
            post.setHeader("Cookie",jsessionId+";");
//
            HttpEntity e=post.getEntity();

//            HttpResponse response1=httpClient.execute(post);
//            System.out.println("状态码;"+response1.getStatusLine().getStatusCode());
//            HttpEntity enitty1 = response1.getEntity();
//            //将内容转码
//            info = new String (EntityUtils.toString(enitty1).getBytes("iso-8859-1"),"utf-8");
//            System.out.println("post============================");
//            System.out.println(info);
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }



    //    input type="hidden" name="lt" value="LT-114084-cBxkYfuKZAP3RjQbdvdSlFe4bkHfNm1483408591118-OfEs-cas" />
//    <input type="hidden" name="execution" value="e1s1" />
//    <input type="hidden" name="_eventId" value="submit" />
//    <input type="hidden" name="rmShown" value="1">
    public static String doGet(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response=null;
        String info=null;
        try {
            //用于构建参数列表
            URIBuilder builder=new URIBuilder(url);
            if(params!=null){
                for(String key:params.keySet())
                    builder.addParameter(key,params.get(key));
            }
            URI url2=builder.build();
            HttpGet get = new HttpGet(url2);
            response=httpClient.execute(get);
            //获取响应状态码
            int status = response.getStatusLine().getStatusCode();
//            System.out.println("response status code is " + status);
            //获取网页源码
            HttpEntity enitty = response.getEntity();
            //将内容转码
            info = new String (EntityUtils.toString(enitty).getBytes("iso-8859-1"),"utf-8");
            //获取cookie
            Header headers[] = response.getHeaders("Set-Cookie");
            String jseesionId=null;
            for(Header h:headers){
                String value=h.getValue();
                if(value.contains("JSESSIONID")) {
                    jseesionId = value.substring(11, value.indexOf(";"));
                    System.out.println(jseesionId);
                }
            }

//            Cookie[] cookies=httpClient.

//            System.out.println(info);
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return info;
    }


    public static String doPost(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response=null;
        String info=null;
        try {
            //用于构建参数列表
            HttpPost post=new HttpPost(url);
            List<BasicNameValuePair> paramsList=new ArrayList<BasicNameValuePair>();
            if(params!=null){
                for(String key:params.keySet())
                    paramsList.add(new BasicNameValuePair(key,params.get(key)));
                UrlEncodedFormEntity entity=new UrlEncodedFormEntity(paramsList);
                post.setEntity(entity);
            }
            response=httpClient.execute(post);
            //获取响应状态码
            int status = response.getStatusLine().getStatusCode();
//            System.out.println("response status code is " + status);
            //获取网页源码
            HttpEntity enitty = response.getEntity();
            //将内容转码
            info = new String (EntityUtils.toString(enitty).getBytes("iso-8859-1"),"utf-8");
//            System.out.println(info);
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }
}
