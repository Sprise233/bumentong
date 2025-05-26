package com.github.sprise233.bumentong.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectResult;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Random;

@Component
@Slf4j
public class AliOssUtils {
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.region}")
    private String region;

    private static String endpointStatic;
    private static String bucketNameStatic;
    private static String regionStatic;

    @PostConstruct
    private void init() {
        endpointStatic = endpoint;
        bucketNameStatic = bucketName;
        regionStatic = region;
        log.info("AliOssUtils 配置已初始化");
    }


    private static String generateFileName(String fileName) {
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        Random random = new Random();
        return System.currentTimeMillis() + String.format("%05d", random.nextInt(100000)) + suffix;
    }

    public static String uploadFile(String fileName, byte[] fileBytes) throws com.aliyuncs.exceptions.ClientException {
        // 从环境变量中获取访问凭证。运行本代码示例之前，请先配置环境变量
        EnvironmentVariableCredentialsProvider credentialsProvider =
                CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 创建OSSClient实例。
        // 当OSSClient实例不再使用时，调用shutdown方法以释放资源。
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        // 显式声明使用 V4 签名算法
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint("https://" + endpointStatic)
                .credentialsProvider(credentialsProvider)
                .region(regionStatic)
                .build();
        try {
            ossClient.createBucket(bucketNameStatic);
            String objectName = generateFileName(fileName);
            ossClient.putObject(bucketNameStatic, objectName, new ByteArrayInputStream(fileBytes));
            return "https://" + bucketNameStatic + "." + endpointStatic + "/" + objectName;
        } catch (OSSException oe) {
            log.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.error("Error Message:" + oe.getErrorMessage());
            log.error("Error Code:" + oe.getErrorCode());
            log.error("Request ID:" + oe.getRequestId());
            log.error("Host ID:" + oe.getHostId());
        }
        finally {
            if (ossClient != null) {
                ossClient.shutdown();
                log.info("已发送请求： <endpoint:" + endpointStatic + "bucketName:" + bucketNameStatic + "region:" + regionStatic + "> ");
            }
        }
        return null;
    }
}
