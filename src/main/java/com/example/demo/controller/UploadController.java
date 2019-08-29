package com.example.demo.controller;



import com.mongodb.util.JSON;
import org.apache.tomcat.util.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;



@RestController
@RequestMapping("/rest")
public class UploadController {
    // 更改路径
    private String UPLOAD_FOLDER = "fileStorage";

    @RequestMapping(value = "/singlefile", method = RequestMethod.POST)
    public Object singleFileUpload(MultipartFile file) {
        System.out.println("传入的文件参数：{}" + file.toString());
        if (Objects.isNull(file) || file.isEmpty()) {
            System.out.println("文件为空");
            return "文件为空，请重新上传";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + File.separator + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            System.out.println("文件写入成功...路径："+ path);
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
/*
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public Object downloadFile(@RequestParam String fileName, final HttpServletResponse response, final HttpServletRequest request){
        System.out.println("in");
        OutputStream os = null;
        InputStream is= null;
        try {
            // 取得输出流
            os = response.getOutputStream();
            // 清空输出流
            response.reset();
            response.setContentType("application/x-download;charset=GBK");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("utf-8"), "iso-8859-1"));
            //读取流
            File f = new File(UPLOAD_FOLDER + File.separator + fileName);
            is = new FileInputStream(f);
            if (is == null) {
                System.out.println("下载附件失败，请检查文件“" + fileName + "”是否存在");
                return "下载附件失败，请检查文件“" + fileName + "”是否存在";
            }
            //复制
            IOUtils.copy(is, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            return "下载附件失败,error:"+e.getMessage();
        }
        //文件的关闭放在finally中
        finally
        {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

*/
}
