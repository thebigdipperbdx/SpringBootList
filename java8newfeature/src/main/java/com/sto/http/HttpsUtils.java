package com.sto.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * @author yanyugang
 * @description HTTP工具类
 * @date 2019-03-28 9:47
 */
public class HttpsUtils {
	private static Logger logger = Logger.getLogger(HttpsUtils.class);

	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		// 初始化一个json对象
		String result = "";
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tmManagers = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tmManagers, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory sslSocket = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
			httpsURLConnection.setSSLSocketFactory(sslSocket);

			//设置超时时间为10秒
			httpsURLConnection.setConnectTimeout(10000);
			httpsURLConnection.setReadTimeout(10000);

			httpsURLConnection.setDoOutput(true);
			httpsURLConnection.setDoInput(true);
			httpsURLConnection.setUseCaches(false);
			// 设置请求方式 GET/POST
			httpsURLConnection.setRequestMethod(requestMethod);
			// 不考虑大小写。如果两个字符串的长度相等，并且两个字符串中的相应字符都相等（忽略大小写），则认为这两个字符串是相等的。
			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpsURLConnection.connect();
			}
			// 当有数据需要提交时,往服务器端写内容 也就是发起http请求需要带的参数
			if (StringUtils.isNotEmpty(outputStr)) {
				OutputStream outputStream = httpsURLConnection.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 获得输入流 读取服务器端返回的内容
			InputStream inputStream = httpsURLConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer stringBuffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				stringBuffer.append(str);
			}
			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpsURLConnection.disconnect();
			// 将字符串转换为json对象
			result = stringBuffer.toString();
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out.");
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}
		return result;
	}
}
