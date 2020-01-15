package com.marketshrimp.io.bio;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/5
 */
public class ReadFile {

    public static void main(String[] args)throws Exception {
        Map<String, String> sxfMap = new HashMap<>();
        Map<String, String> yjMap = new HashMap<>();
        String path = "C:\\Users\\alw\\Desktop\\二期运营平台\\数仓\\吉林\\0406\\9";
        BigDecimal sxfTotal = BigDecimal.ZERO;
        BigDecimal yjTotal = BigDecimal.ZERO;
        File sourceDir = new File(path);
        File[] files = sourceDir.listFiles();
        for(int j = 0; j < files.length; j++) {
            File dir = files[j];
            for(File file :dir.listFiles()) {
                String fileName = file.getName();
                byte[] by = new byte[Long.valueOf(file.length()).intValue()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(by);
                String content = new String(by, "UTF-8");
                String[] rows = content.split("\n");
                if(fileName.indexOf("shchshxf") != -1) { // 手续费
                    for(int i = 0; i <rows.length; i++) {
                        if(i==0)continue;
                        String sxf = rows[i].split(" ")[5];
                        if(!"0.0".equals(sxf)) {
                            BigDecimal sxfDecimal = new BigDecimal(sxf);
                            sxfTotal = sxfTotal.add(sxfDecimal);
                            sxfMap.put(String.valueOf(j+1), "有值");
                        }
                    }
                }else {// 佣金
                    for(int i = 0; i <rows.length; i++) {
                        if(i==0)continue;
                        String sxf = rows[i].split(" ")[5];
                        if(!"0.0".equals(sxf)) {
                            BigDecimal sxfDecimal = new BigDecimal(sxf);
                            yjTotal = yjTotal.add(sxfDecimal);
                            yjMap.put(String.valueOf(j+1), "有值");
                        }
                    }
                }
            }

        }
         System.out.println(sxfTotal.toString());
         System.out.println(yjTotal.toString());
    }

}
