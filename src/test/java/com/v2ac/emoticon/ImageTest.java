package com.v2ac.emoticon;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.v2ac.emoticon.common.ImageMergeUtils.*;

public class ImageTest {
    /**
     * Java 测试图片叠加方法
     */
    public static void overlyingImageTest() {

        String sourceFilePath = "D://test//test1.jpg";
        String waterFilePath = "D://test//test2.jpg";
        String saveFilePath = "D://test//overlyingImageNew.jpg";
        try {
            BufferedImage bufferImage1 = getBufferedImage(sourceFilePath);
            BufferedImage bufferImage2 = getBufferedImage(waterFilePath);

            // 构建叠加层
            BufferedImage buffImg = overlyingImage(bufferImage1, bufferImage2, 0, 0, 1.0f);
            // 输出水印图片
            generateSaveFile(buffImg, saveFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Java 测试图片合并方法
     */
    public static void imageMargeTest() {
        // 读取待合并的文件
        BufferedImage bi1 = null;
        BufferedImage bi2 = null;
        // 调用mergeImage方法获得合并后的图像
        BufferedImage destImg = null;
        System.out.println("下面是垂直合并的情况：");
        String saveFilePath = "D://test//new1.jpg";
        String divingPath = "D://test//new2.jpg";
        String margeImagePath = "D://test//margeNew.jpg";
        try {
            bi1 = getBufferedImage(saveFilePath);
            bi2 = getBufferedImage(divingPath);
            // 调用mergeImage方法获得合并后的图像
            destImg = mergeImage(bi1, bi2, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 保存图像
        generateSaveFile(destImg, margeImagePath);
        System.out.println("垂直合并完毕!");
    }

    public static void main(String[] args) {
        // 测试图片的叠加
        overlyingImageTest();
        // 测试图片的垂直合并
        imageMargeTest();
    }
}
