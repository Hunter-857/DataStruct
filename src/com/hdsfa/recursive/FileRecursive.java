package com.hdsfa.recursive;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

public class FileRecursive {

    /*
    *  not Recursive
    * */
    public static void folderMethod1(String path) {
        int fileNum = 0, folderNum = 0;
        File fileReadIn = new File(path);
        LinkedList<File> list = new LinkedList<>();

        if (fileReadIn.exists()) {
            if (null != fileReadIn.listFiles()) {//get all of the files under that file.
                list.addAll(Arrays.asList(fileReadIn.listFiles()));
                while (!list.isEmpty()) {
                    File[] files = list.removeFirst().listFiles();//read from the first file
                    if (null == files) {
                        continue;
                    }
                    for (File f : files) {
                        if (f.isDirectory()) {
                            System.out.println("文件夹:" + f.getAbsolutePath());
                            list.add(f);
                            folderNum++;
                        } else {
                            System.out.println("文件:" + f.getAbsolutePath());
                            fileNum++;
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹数量:" + folderNum + ",文件数量:" + fileNum);
    }
    /*
    * Recursive
    * */

    public static void folderMethod2(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        folderMethod2(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    public static void main(String[] args) {
        FileRecursive.folderMethod1("C:\\Users\\Administrator\\Desktop\\");
    }
}
