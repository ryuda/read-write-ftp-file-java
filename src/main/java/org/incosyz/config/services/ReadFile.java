package org.incosyz.config.services;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Stelan Briyan
 */
public class ReadFile {

    public void read(FTPClient ftpClient) throws IOException {

        InputStream inputStream = ftpClient.retrieveFileStream("filename.txt");

        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());

        //Closing the channels
        sc.close();
        inputStream.close();

    }
}
