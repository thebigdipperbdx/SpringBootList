package com.me.guava.csv;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    public static char separator = ',';

    public static void main(String[] args) throws Exception {
        /*// 测试导出
        String filePath = "D:/scoreInfo.csv";
        List<String[]> dataList = new ArrayList<String[]>();
        //添加标题
        dataList.add(new String[]{"学号", "姓名", "分数"});
        for (int i = 0; i < 10; i++) {
            dataList.add(new String[]{"2010000" + i, "张三" + i, "8" + i});
        }
        createCSV(dataList, filePath);

        // 读取CSV文件
        readCSV(filePath);*/

        String filePath = "D:/test.csv";
        //writeBcp();
        readCSV22(filePath);
    }

    /**
     * 读取CSV文件
     * @param filePath:全路径名
     */
    public static List<String[]> readCSV(String filePath) throws Exception {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader(filePath, separator, Charset.forName("GBK"));

            // 读取表头
            reader.readHeaders();
            String[] headArray = reader.getHeaders();//获取标题
            System.out.println(headArray[0] + headArray[1] + headArray[2]);

            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                // 读一整行
                System.out.println(reader.getRawRecord());
                // 读这行的第一列
                System.out.println(reader.get("学号"));
                // 读这行的第二列
                System.out.println(reader.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }

    /**
     * 生成CSV文件
     * @param dataList:数据集
     * @param filePath:全路径名
     */
    public static boolean createCSV(List<String[]> dataList, String filePath) throws Exception {
        boolean isSuccess = false;
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath, true);
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            writer = new CsvWriter(out, separator, Charset.forName("GBK"));
            for (String[] strs : dataList) {
                writer.writeRecord(strs);
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }


    private static void writeBcp() throws IOException {
        //Create bcp file if not exist
        File bcpFile = new File("d:/test.csv");
        //bcpFile.delete();
        byte[] bom = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        //boolean newFile = false;
        FileOutputStream bcpFileWriter = new FileOutputStream(bcpFile);
        bcpFileWriter.write(bom);
        //bcpFile.delete();
        String title = "\"MD5\",\"扫描文件名\",\"扫描时间\"," +
                "\"是否病毒\",\"安全等级\",\"病毒英文名称\"," +
                "\"病毒变种\",\"病毒类型\",\"病毒影响\"," +
                "\"感染系统\",\"传播方式\",\"备注\"";

        bcpFileWriter.write((new String(title.getBytes(), "utf-8")).getBytes());
        bcpFileWriter.write("\n".getBytes());

        String appStr = "\"" + 123 + "\","
                + "\"" + 123 + "\","
                + 123 + ","
                + 123 + ","
                + 123 + ","
                + "\"" + 123 + "\","
                + "\"\","
                + 123 + ","
                + "\"" + 123 + "\","
                + "\"" + 123 + "\","
                + "\"" + 123 + "\","
                + "\"" + 123 + "\"\n";

        bcpFileWriter.write(appStr.getBytes());
        bcpFileWriter.close();
    }


    /**
     * 读取CSV文件
     * @param filePath:全路径名
     */
    public static List<String[]> readCSV22(String filePath) throws Exception {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader(filePath, separator, Charset.forName("UTF-8"));

            // 读取表头
            reader.readHeaders();
            String[] headArray = reader.getHeaders();//获取标题
            System.out.println(headArray[0] + headArray[1] + headArray[2]);

            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                // 读一整行
                System.out.println(reader.getRawRecord());
                // 读这行的第一列
                System.out.println(reader.get("学号"));
                // 读这行的第二列
                System.out.println(reader.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }
}