package com.cc.test;

import java.io.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //获取文件资源
        File file = new File("E:\\工作环境\\120msg_20180314095626.txt");
        String[] str = clearStr(readtxt(file));
      //  getQuestion(str,"所有问题");
       // getQuestion1(str,"统计导数");
       // getQuestion2(str,"统计实体");
       // getQuestion3(str,"关系");
       // getQuestion4(str,"事件");
        //getQuestion5(str,"视图");
        getQuestion6(str,"分隔符");
        //getQuestion7(str,"记录条数");
    }

    /**
     * 通过字符流来读取文件
     *
     * @param file
     * @return
     */
    public static String readtxt(File file) {
        Reader reader = null;
        StringBuffer str = new StringBuffer();
        System.err.println("读取字符串以字符为单位");
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {

                if (((char) tempchar) != '\r') {
                    str.append((char) tempchar);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    /**
     * 处理缩进字符串
     *
     * @param splitStr
     * @return
     */
    public static String[] clearStr(String splitStr) {

        String[] str = splitStr.split("\\[");
        //  str = str.replaceAll("||||","|");
        return str;
    }

    /**
     * 统计所有问题
     * @param str
     * @param fileName
     */

    public static void getQuestion(String[] str,String fileName) {
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");
            if ((str[i].contains("导") ||str[i].contains("问")||str[i].contains("为什么")||str[i].contains("请"))&&str[i].contains("？")) {
                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;
            }
        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    /**
     * 统计导数
     * @param str
     * @param fileName
     */
    public static  void getQuestion1(String[] str,String fileName){
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");
            if ((str[i].contains("导"))&&str[i].contains("？")) {
                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;
            }
        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    /**
     * 统计实体问题
     * @param str
     * @param fileName
     */
    public static  void getQuestion2(String[] str,String fileName){
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");
            if (str[i].contains("实体")&&str[i].contains("？")) {
                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;
            }
        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    /**
     * 导关系
     * @param str
     * @param fileName
     */
    public static  void getQuestion3(String[] str,String fileName){
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");
            if (str[i].contains("关系")&&str[i].contains("？")) {
                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;
            }
        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    /**
     * 导事件
     * @param str
     * @param fileName
     */

    public static  void getQuestion4(String[] str,String fileName){
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");
            if (str[i].contains("事件")&&str[i].contains("？")) {
                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;
            }
        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    public static  void getQuestion5(String[] str,String fileName){
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");
            if (str[i].contains("视图")) {
                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;
            }
        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    public static  void getQuestion6(String[] str,String fileName){
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");
            if (str[i].contains("分")&&str[i].contains("符")) {
                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;
            }
        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    public static  void getQuestion7(String[] str,String fileName){
        StringBuffer buffer = new StringBuffer();
        int k = 1;
        for (int i = str.length - 1; i > 0; i--) {
            str[i].replace("\n", "");

                buffer.append(k + "--->");
                buffer.append(str[i] + "\r");
                k++;

        }
        outFile(buffer.toString(),"E:\\工作环境\\"+fileName+"."+k+".txt");

    }

    /**
     * 输出内容到txt
     * @param context
     */
    public static void outFile(String context,String fileName){

        Writer writer =null;
        try {
            FileOutputStream foss = new FileOutputStream(fileName);
           writer = new OutputStreamWriter(foss);
            writer.write(context);
            System.out.println("文件已经生成");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            try {
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
