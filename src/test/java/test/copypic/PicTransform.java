package test.copypic;


import java.io.*;
import java.util.ArrayList;

public class PicTransform {
    private static String oriPathPrefix = "/app/ecomnew/cms/online/";

    public static void main(String[] args) {
        PicTransform t = new PicTransform();
        String inFileName = "C:\\Users\\alw\\Desktop\\二期运营平台\\老商城商品数据迁移新商城\\老商城商品数据源\\汇丰银行\\第二批\\pic.txt";
        String outFileName = "C:\\Users\\alw\\Desktop\\二期运营平台\\老商城商品数据迁移新商城\\老商城商品数据源\\汇丰银行\\第二批\\productNew.txt";
        t.writeFile(outFileName, t.transferProductPic(inFileName));
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public ArrayList<Mess> transferProductPic(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        ArrayList<Mess> list = new ArrayList();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
            String tempString = null;
            // 一次读入一行，直到读入0为文件结束
            int a = 0;
            String prefix = "/app/ecomnew/bak/imagebak";
            while (!(tempString = reader.readLine()).equals("0")) {
                //tempString
                String[] paths = tempString.split(",");
                for(int i=0; i<paths.length; i++) {
                    String path = paths[i].trim();
                    if(path!=null && !"".equals(path)) {
                        String mkdir = "mkdir -p " + prefix + path.substring(0, 22);
                        String cp = "cp " + oriPathPrefix + path.substring(1) + " " + prefix + path;
                        Mess mess = new Mess(mkdir, cp);
                        list.add(mess);
                    }
                }
                a++;
            }
            System.out.println("line:"+a+";num:"+list.size());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }

    public void writeFile(String fileName, ArrayList<Mess> list) {
        try {
            File writeName = new File(fileName); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);
            for(Mess m:list) {
                out.write(m.getName()+"\n");
                out.write(m.getDate()+"\n");
            }
            out.flush(); // 把缓存区内容压入文件
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
