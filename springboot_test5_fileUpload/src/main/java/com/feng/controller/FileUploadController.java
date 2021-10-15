package com.feng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String format = sdf.format(new Date());

    @RequestMapping("/file")
    public ModelAndView file() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("file");
        return mv;
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("fileName") MultipartFile file, HttpServletRequest request) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String realPath = "D:/uploadFile/";
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            file.transferTo(new File(folder, newName));
//            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format  + "/" + newName;
            String filePath = realPath + format + "/" + newName;
            return filePath;
//            return "上传成功！";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }

    @RequestMapping("/uploads")
    public String uploads(@RequestParam("fileNames") MultipartFile[] files, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String filePath = "";
        for (MultipartFile file : files) {
            File folder = new File(realPath + format);
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }
            String oldName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                file.transferTo(new File(folder, newName));
                filePath += request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + "/" + newName + "\t";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败！";
            }
        }
        return filePath;
    }
}
