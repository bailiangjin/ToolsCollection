package com.bailiangjin.toolscollection.delete_res;

import com.kevin.javaawtlib.callback.FilePathCallback;
import com.kevin.javaawtlib.swing.FileChooser;
import com.kevin.javabaselib.utils.StringUtils;

/**
 * Created by bailiangjin on 16/5/19.
 */
public class DeleteUselessResMain {

    //项目路径
   private static String projectPath = "";
    // 使用cmd命令生成的保存了资源调用情况的文件路径
   private static String lintResultFilePath = "";


    public static void main(String[] args) {




        // dex文件选择器
        new FileChooser("请选择工程目录", new FilePathCallback() {

            @Override
            public void onFileSelected(String filePath) {
                System.out.println("工程目录:" + filePath);

                projectPath = filePath;


                // 文件输出路径选择器
                new FileChooser("请选择lint检查结果文件", new FilePathCallback() {

                    @Override
                    public void onFileSelected(String filePath) {
                        System.out.println("lint文件路径:" + filePath);
                        lintResultFilePath =filePath;

                        if (StringUtils.isEmpty(projectPath)||StringUtils.isEmpty(lintResultFilePath)){
                            System.out.println("工程路径或lint文件路径为空:工程路径:" + filePath+"lint文件路径:"+ lintResultFilePath);
                            return;
                        }else{
                            DeleteUselessResTool.deleteUselessRes(projectPath, lintResultFilePath);
                        }
                        // 退出 关闭窗口界面
                        System.exit(0);

                    }
                });

            }
        });
    }
}
