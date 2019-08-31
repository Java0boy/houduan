package com.example.demo.controller;



import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class UploadController {
    // 更改路径
    private String UPLOAD_FOLDER = "fileStorage";

    @RequestMapping(value = "/singlefile", method = RequestMethod.POST)
    public Object singleFileUpload(MultipartFile file) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (Objects.isNull(file) || file.isEmpty()) {
            System.out.println("文件为空");
            resultMap.put("success", 0);
            resultMap.put("message", "文件为空！");
            resultMap.put("url","");
            return resultMap;
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
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url","rest/files/" + file.getOriginalFilename());
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("success", 0);
            resultMap.put("message", "后端异常！");
            resultMap.put("url","");
            return resultMap;
        }
    }

    @RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
    public Object ImgUpload( @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (Objects.isNull(file) || file.isEmpty()) {
            System.out.println("文件为空");
            resultMap.put("success", 0);
            resultMap.put("message", "文件为空！");
            resultMap.put("url","");
            return resultMap;
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
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url","rest/files/" + file.getOriginalFilename());
            return resultMap;

        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("success", 0);
            resultMap.put("message", "后端异常！");
            resultMap.put("url","");
            return resultMap;
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
