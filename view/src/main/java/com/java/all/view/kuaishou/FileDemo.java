package com.java.all.view.kuaishou;

import com.google.common.collect.Maps;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: ps
 * @since: 2019/4/28  4:07 PM
 * @version: 1.0.0
 * @desc 有个5G大小的文件，文件按行存储，内容格式：时间【tab缩进'\t'】用户ID 域名 例如：2018-01-12 12:21:21.212  2818812112 http://www.baidu.com
 * 统计出该文件中以用户维度统计今天的访问量
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("access.log");
        // file 切分成N个小文件 具体怎么切分 目前不了解 使用file.listFiles() 代替
        File[] files = file.listFiles();
        int n = files.length;
        int processors = Runtime.getRuntime().availableProcessors();
        int works = n > processors ? processors : n;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(works, works, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(1000));
        CountDownLatch latch = new CountDownLatch(works);
        for (File f : files) {
            executor.submit(new FileOperator(f, latch));
        }

    }



}


/**
 * 文件操作类
 */
class FileOperator implements Runnable {
    private File file;
    private CountDownLatch latch;

    public FileOperator(File file, CountDownLatch latch) {
        this.file = file;
        this.latch = latch;
    }

    @Override
    public void run() {
        // 文件IO操作
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream((file)));
            char[] chars = new char[1024];
            reader.read(chars);
            String record = new String(chars);
            if (record == null || "".equals(record)) {
                return;
            }
            build(record);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* 解析并统计 */
    Map<Long, Integer> build(String record) {
        String[] records = record.split("\t");
        if (records.length != 3) {
            return null;
        }

        // TODO: 2019/4/28 字符串解析
        latch.countDown();
        return Maps.newHashMap();
    }
}
