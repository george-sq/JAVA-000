package com.geektime.learning;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Objects;

/**
 * @Title: PACKAGE_NAME -> com.geek.learning.CustomClassloader
 * @Description: TODO
 * @Author: qiao-shen
 * @Date: 2020/10/18 13:56
 */

public class CustomClassloader extends ClassLoader implements Serializable {

    private static final long serialVersionUID = -4610579737804506315L;
    private static final URL RESOURCE_PATH = CustomClassloader.class.getClassLoader().getResource("");
    private static final String SPECIFIC_CLASS_NAME = "Hello.xlass";

    private byte[] getResourceFilesAsByte(String fileName) {
        byte[] retBytes = null;
        if (null != fileName) {
            try {
                String filePath = String.format("%s/%s", Objects.requireNonNull(RESOURCE_PATH).getPath(), fileName);
                File file = new File(filePath);
                retBytes = new byte[(int) file.length()];
                FileInputStream fileInStream = new FileInputStream(file);
                int totals = fileInStream.read(retBytes);
                System.out.println(String.format("  ==> 读取 加密class文件内容: totals = %d 字节", totals));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retBytes;
    }
    
    private byte[] transformBytes(byte[] arrBytes) {
        byte[] retBytes = null;
        if (null != arrBytes) {
            retBytes = new byte[arrBytes.length];
            for (int i = 0; i < arrBytes.length; i++) {
                retBytes[i] = (byte) (255 - (int) arrBytes[i]);
            }
            System.out.println(String.format("  ==> 解密 加密class文件内容: totals = %d 字节", retBytes.length));
        }
        return retBytes;
    }
    
    private void loadSpecificClass() {
        // 加载 指定的加密class文件内容
        byte[] xlassBytes = this.getResourceFilesAsByte(SPECIFIC_CLASS_NAME);
        // 转换 加密class文件的字节码
        byte[] classBytes = this.transformBytes(xlassBytes);
        // 执行 加密class文件内容
        if (null != classBytes) {
            // 加载 加密class
            System.out.println("  ==> 加载 加密class: Hello.class");
            try {
                Class<?> helloClass = defineClass("Hello", classBytes, 0, classBytes.length);
                // 创建 加密class类对象实例
                Object obj = helloClass.newInstance();
                Method method = helloClass.getMethod("hello");
                System.out.println();
                // 执行 加密class类对象实例的方法
                method.invoke(obj);
                System.out.println();
                System.out.println(String.format("  ==> 执行 加密class类对象的实例方法: invoke %s Method", "hello"));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("获取 加密class文件内容 失败");
        }
    }

    public static void main(String[] args) {
        System.out.println("执行作业逻辑 ...");
        new CustomClassloader().loadSpecificClass();
        System.out.println("执行完成");
    }

}
