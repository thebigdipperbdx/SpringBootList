package com.fuzzy.search.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author yanyugang
 * @description
 * @date 2019-08-13 17:20
 */
public class FileUtil {
    private String path="D:/知识库.txt";


    public void testReadFileLines() throws IOException{
        FileInputStream inputStream = FileUtils.openInputStream(new File(path));
        try {
            LineIterator it = IOUtils.lineIterator(inputStream, "GBK");
            while (it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
            }
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }


}
