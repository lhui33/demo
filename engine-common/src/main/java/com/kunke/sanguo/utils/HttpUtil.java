package com.kunke.sanguo.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <b>功能：</b>Http请求工具类<br>
 * <br>
 * 
 * @author Charles
 * @version 2015年7月12日
 *
 */
public class HttpUtil {
	private HttpUtil(){}

    private static final String CHARSET = "UTF-8";

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	/**
	 * <b>功能描述：</b>get请求<br>
	 * <b>修订记录：</b><br>
	 * <li>2015年7月12日&nbsp;&nbsp;|&nbsp;&nbsp;Charles&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @author Charles
	 * 
	 * @param 	url	请求地址
	 * @return	String 请求结果
	 * @throws 	Exception
	 */
	public static String getString(String url, String type) throws Exception{
		HttpGet httpGet = null;
		String responseStr = null;
		HttpClient client = null;
		try {
			httpGet = new HttpGet(url);
			if ("https".equals(type)) {
				client = HttpClients.createDefault();
			} else {
				client = getHttpClient();
			}
			//设置请求配置信息 如：请求超时，请求代理等
			httpGet.setConfig(HttpUtil.getRequestConfig());
			//执行请求here
//			logger.info("===begin request for url:" + url);
			HttpResponse response = client.execute(httpGet);
//			logger.info("===after request for url:" + url);
			//获取请求状态码
			int statusCode = response.getStatusLine().getStatusCode();
			//返回码不为200 抛出异常
			if (HttpStatus.SC_OK != statusCode) {
				throw new IOException("bad get request ,return code is:" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseStr = EntityUtils.toString(entity, CHARSET);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			httpGet.releaseConnection();
		}
		return responseStr;
	}
	
	/**
	 * <b>功能描述：</b>post请求方法<br>
	 * <b>修订记录：</b><br>
	 * <li>2015年7月12日&nbsp;&nbsp;|&nbsp;&nbsp;Charles&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @author Charles
	 * 
	 * @param url			请求地址
	 * @param parameter		请求参数
	 * @return String		请求结果
	 * @throws Exception
	 */
	public static String postString(String url, Map<String, Object> parameter) throws Exception{
		System.out.print("发送消息");
		String responseStr = null;
		HttpPost post = null;
		try {
			post = new HttpPost(url);
			//设置post表单参数
			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			for (Entry<String, Object> entry : parameter.entrySet()) {
				BasicNameValuePair nameValue = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
				paramList.add(nameValue);
			}
			//设置编码格式
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(paramList, CHARSET);
			post.setEntity(uefEntity);
			HttpClient client = HttpClients.createDefault();
			System.out.print("执行请求");
			//执行请求
			HttpResponse response = client.execute(post);
			System.out.print("执行请求1");
			//获取请求状态码
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.print("statusCode:"+statusCode);
			//返回码不为200 抛出异常
			if (HttpStatus.SC_OK != statusCode) {
				throw new IOException("bad get request ,return code is:" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseStr = EntityUtils.toString(entity, CHARSET);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
		}
		
		return responseStr;
	}
	
	/**
	 * <b>功能描述：</b>apacheHttpJson请求<br>
	 * <b>修订记录：</b><br>
	 * <li>2016年1月3日&nbsp;&nbsp;|&nbsp;&nbsp;Charles&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @author Charles
	 *
	 * @param urls
	 * @param json
	 * @return
	 */
	public static String httpJson(String urls, String json){
		HttpPost httpPost = null;
		String responseStr = null;
		try {
			httpPost = new HttpPost(urls);
			StringEntity se = new StringEntity(json, Charset.forName("UTF-8"));
			httpPost.addHeader("content-type", "application/json; charset=UTF-8");
			httpPost.addHeader("Accept", "application/json");
			httpPost.addHeader("Accept-Encoding", "UTF-8");
			se.setContentType(CONTENT_TYPE_TEXT_JSON);
	        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
	        httpPost.setEntity(se);
	        HttpClient client = HttpClients.createDefault();
	        //执行请求
			HttpResponse response = client.execute(httpPost);
			//获取请求状态码
			int statusCode = response.getStatusLine().getStatusCode();
			logger.info("statusCode=={}",statusCode);
			//返回码不为200 抛出异常
			if (HttpStatus.SC_OK != statusCode) {
				throw new IOException("bad get request ,return code is:" + statusCode);
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseStr = EntityUtils.toString(entity, CHARSET);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (httpPost != null) {
				httpPost.releaseConnection();
			}
		}
		
		return responseStr;
	}
	
	
	
	
	/**
	 * 设置请求参数
	 * @return RequestConfig
	 */
	private static RequestConfig getRequestConfig(){
		Builder configBuilder = RequestConfig.custom();
		//请求超时1000毫秒
		configBuilder.setConnectionRequestTimeout(1000);
		//响应超时时间1000毫秒
		configBuilder.setConnectTimeout(1000);
		//读取超时2000毫秒
		configBuilder.setSocketTimeout(1000);
		
		RequestConfig config = configBuilder.build();
		
		return config;
	}
	
	public static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }
	
    public static String readHttpResponse(HttpResponse httpResponse)
            throws ParseException, IOException {
        StringBuilder builder = new StringBuilder();
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        builder.append("status:" + httpResponse.getStatusLine());
        builder.append("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            builder.append("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            String responseString = EntityUtils.toString(entity);
            builder.append("response length:" + responseString.length());
            builder.append("response content:" + responseString.replace("\r\n", ""));
        }
        return builder.toString();
    }
	
	private static final String APPLICATION_JSON = "application/json;charset=UTF-8";
    
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json;charset=UTF-8";
    
    private static SSLContextBuilder builder = null;
    
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    static {
        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(
						java.security.cert.X509Certificate[] arg0, String arg1) {
					// TODO Auto-generated method stub
					return true;
				}
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new PlainConnectionSocketFactory())
                    .register("https", sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);//max connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
//    	String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx33013d83315f3550&secret=4a8991030ecb5d08c37637647fe718c3&js_code=JSCODE&grant_type=authorization_code";
//    	try {
//			System.out.println(getString(url, "https"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}



		String strs = "琶洲|琶洲新城";
		String[] arrs = strs.split("\\|");
		for (String sss: arrs) {
			Boolean s = ArrayUtils.contains(arrs, sss);
			System.out.println(sss);
		}

    }
}
