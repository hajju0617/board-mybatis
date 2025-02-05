package com.project.hajju.boardmybatis.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtils {
    @Value("${file.directory}")
    private String fileDirectory;

    public String savePath(String storedFileName) {
        return fileDirectory + storedFileName;
    }

    // 저장시 파일명.
    public String getStoredFileName(String originalFileName) {
        return System.currentTimeMillis() + "_" + originalFileName;
    }


}
