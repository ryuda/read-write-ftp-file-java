package org.incosyz.config.services;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Stelan Briyan
 */
public class FileUploader {

    public void uploadFile(FTPClient ftpClient) throws IOException {

        // Path to local file need to upload
        String filePath = "src/main/resources/samplefile.txt";

        File file = new File(filePath);
        InputStream input = new FileInputStream(file);
        ftpClient.storeFile(file.getName(), input);

    }

}
