package com.ll.global.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AppConfig {
    private static Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        AppConfig.environment = environment;
    }

    public static boolean isProd() {
        return environment.matchesProfiles("prod");
    }

    public static boolean isDev() {
        return environment.matchesProfiles("dev");
    }

    public static boolean isTest() {
        return environment.matchesProfiles("test");
    }

    public static boolean isNotProd() {
        return !isProd();
    }

    @Getter
    private static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        AppConfig.objectMapper = objectMapper;
    }

    @Getter
    private static Tika tika;

    @Autowired
    public void setTika(Tika tika) {
        AppConfig.tika = tika;
    }

    @Getter
    private static String siteFrontUrl;

    @Value("${custom.site.frontUrl}")
    public void setSiteFrontUrl(String siteFrontUrl) {
        AppConfig.siteFrontUrl = siteFrontUrl;
    }

    @Getter
    private static String siteBackUrl;

    @Value("${custom.site.backUrl}")
    public void setSiteBackUrl(String siteBackUrl) {
        AppConfig.siteBackUrl = siteBackUrl;
    }

    @Getter
    public static String genFileDirPath;

    @Value("${custom.genFile.dirPath}")
    public void setGenFileDirPath(String genFileDirPath) {
        this.genFileDirPath = genFileDirPath;
    }

    @Getter
    private static String springServletMultipartMaxFileSize;

    @Value("${spring.servlet.multipart.max-file-size}")
    public void setSpringServletMultipartMaxFileSize(String springServletMultipartMaxFileSize) {
        this.springServletMultipartMaxFileSize = springServletMultipartMaxFileSize;
    }

    @Getter
    private static String springServletMultipartMaxRequestSize;

    @Value("${spring.servlet.multipart.max-request-size}")
    public void setSpringServletMultipartMaxRequestSize(String springServletMultipartMaxRequestSize) {
        this.springServletMultipartMaxRequestSize = springServletMultipartMaxRequestSize;
    }

    public static String getTempDirPath() {
        return System.getProperty("java.io.tmpdir");
    }

    private static String resourcesSampleDirPath;

    @SneakyThrows
    public static String getResourcesSampleDirPath() {
        if (resourcesSampleDirPath == null) {
            ClassPathResource resource = new ClassPathResource("sample");

            resourcesSampleDirPath = resource.getFile().getAbsolutePath();
        }

        return resourcesSampleDirPath;
    }
}
