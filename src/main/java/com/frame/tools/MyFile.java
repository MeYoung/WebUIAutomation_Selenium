package com.frame.tools;

import java.io.File;

/**
 * Created by 米阳 on 2017/10/16.
 */
public class MyFile {

    /**
     * 判断文件是否存在
     *
     * @param filePath 文件路劲
     * @return ture  or  false
     */
    public static boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    /**
     * 判断文件是否存在，没有就新建
     *
     * @param filePath 文件路径
     */
    public static void creatFile(String filePath) {
        MyFile myFile = new MyFile();
        if (!MyFile.fileExists(filePath)) {
            File file = new File(filePath);
            file.mkdir();
        }
    }

    /**
     * 删除目录及目录下所有文件和文件夹
     */
    public static void deleteDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (file.isDirectory()) { //是文件夹
            File temp = null;
            String[] childsFile = file.list(); //获得该目录下的子文件及子文件夹
            for (String s : childsFile) {
                //检查folderPath是不是以"\"节尾
                if (directoryPath.endsWith(File.separator)) {
                    temp = new File(directoryPath + s);
                } else {
                    temp = new File(directoryPath + File.separator + s);
                }
                //delete file
                if (temp != null && temp.isFile()) {  //是文件
                    System.out.println(temp.delete());
                    System.out.println("delete of the fileName: " + temp.getAbsolutePath());
                } else if (temp != null && temp.isDirectory()) {  //是文件夹
                    deleteDirectory(temp.getAbsolutePath());
                }
            }
            file.delete();
        } else if (file.isFile()) {
            file.delete();
        }
    }
}
