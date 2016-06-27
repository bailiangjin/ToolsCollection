package com.bailiangjin.toolscollection.delete_res;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by bailiangjin on 16/5/19.
 */
public class DeleteUselessResTool {



    public static void deleteUselessRes(String projectPath, String lintResultFilePath) {
        BufferedReader reader = null;
        String line;
        int count = 0;
        try {
            reader = new BufferedReader(new FileReader(lintResultFilePath));
            while ((line = reader.readLine()) != null) {
                // 只清理未使用的图片资源，drawable drawable-mdpi
                // drawable-hdpi，drawable-xhdpi
                // drawable-xxhdpi
                if ((line.contains("UnusedResources") && line.contains("res\\drawable-ldpi")) || (line.contains("UnusedResources") && line.contains("res\\drawable-mdpi")) || (line.contains("UnusedResources") && line.contains("res\\drawable-hdpi")) || (line.contains("UnusedResources") && line.contains("res\\drawable-xhdpi")) || (line.contains("UnusedResources") && line.contains("res\\drawable-xxhdpi")))
                {
                    count++;
                    int end = line.indexOf(":");
                    if (end != -1) {
                        String file = line.substring(0, end);
                        String f = projectPath + "\\" + file;
                        boolean flag = new File(f).delete();
                        System.out.println(count + " 删除文件：" + f + "=>是否删除成功:=>" + flag);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("delete error:"+e.getMessage().toString());
            e.printStackTrace();
        }
    }


}
