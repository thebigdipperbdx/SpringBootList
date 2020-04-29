package com.sto.transport.capability.config.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.sto.transport.capability.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

@Component
public class OssUtils {
    private static final Logger logger = LoggerFactory.getLogger(OssUtils.class);

    @Value("${endpoint}")
    private String endpoint;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;
    @Value("${bucketName}")
    private String bucketName;

    /**
     * @param uPic       优车联图片地址
     * @param objectName 图片名称
     * @return
     */
    public String transferuPicUrlToOssUrl(String uPic, String objectName) {
        OSS oss = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try (InputStream inputStream = new URL(uPic).openStream()) {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(getcontentType(objectName.substring(objectName.lastIndexOf("."))));
            oss.putObject(bucketName, objectName, inputStream,objectMetadata);
            // 设置URL过期时间为10年
            Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
            URL picUrl = oss.generatePresignedUrl(bucketName, objectName, expiration);
            logger.info("OssUtils.transferUrlToOssUrl 返回信息====>" + JsonUtil.toJson(picUrl));
            return picUrl != null ? picUrl.toString() : null;
        } catch (Exception e) {
            logger.error("OssUtils.transferUrlToOssUrl出错===>", e);
        } finally {
            oss.shutdown();
        }
        return null;
    }


    /**
     * @param uPic       优车联图片地址
     * @param objectName 图片名称
     * @return
     */
    public String transferInputStreamToOssUrl(InputStream inputStream, String objectName) {
        OSS oss = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(getcontentType(objectName.substring(objectName.lastIndexOf("."))));
            oss.putObject(bucketName, objectName, inputStream,objectMetadata);
            // 设置URL过期时间为10年
            Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
            URL picUrl = oss.generatePresignedUrl(bucketName, objectName, expiration);
            logger.info("OssUtils.transferInputStreamToOssUrl 返回信息===>" + JsonUtil.toJson(picUrl));
            return picUrl != null ? picUrl.toString() : null;
        } catch (Exception e) {
            logger.error("OssUtils.transferInputStreamToOssUrl 出错===>", e);
        } finally {
            oss.shutdown();
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.error("OssUtils.transferInputStreamToOssUrl 关闭输入流出错===>", e);
            }
        }
        return null;
    }

    /**
     * 使得生成的oss URL点击是查看，而不是下载
     * @param FilenameExtension
     * @return
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpg";
    }

}


