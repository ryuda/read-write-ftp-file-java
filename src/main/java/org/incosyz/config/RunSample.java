package org.incosyz.config;

import org.apache.commons.net.ftp.FTPClient;
import org.incosyz.config.services.FileUploader;
import org.incosyz.config.services.ReadFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Stelan Briyan
 */
public class RunSample {
    private static String ftpUrl;
    private static String username;
    private static String password;
    private static int port;

    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src/main/resources/settings.properties");
            prop.load(input);
            ftpUrl = prop.getProperty("org.incosyz.config.ftp.url");
            username = prop.getProperty("org.incosyz.config.ftp.username");
            password = prop.getProperty("org.incosyz.config.ftp.password");
            port = Integer.parseInt(prop.getProperty("org.incosyz.config.ftp.port"));

            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(ftpUrl, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory("/");

            new FileUploader().uploadFile(ftpClient);
            new ReadFile().read(ftpClient);

            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
