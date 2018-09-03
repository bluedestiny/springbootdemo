package com.example.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile multipartFile) {
	    // 1. 判断文件是否为空
		if (multipartFile.isEmpty()) {
			return "文件为空";
		}
		String fileName = multipartFile.getOriginalFilename();
		String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		String filePath = "d://my//";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateDir = sdf.format(new Date());
		File file = new File(filePath + dateDir + File.separator + fileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			multipartFile.transferTo(file);
			return "true";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "false";
		} catch (IOException e) {
			e.printStackTrace();
			return "false";
		}
		
	}
	
	@RequestMapping("/download")
	public void download(HttpServletResponse res) throws Exception {
		String fileName = "文件.txt";
		// 设置下载头
		res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
          os = res.getOutputStream();
          bis = new BufferedInputStream(new FileInputStream(new File("d://my//"
              + fileName)));
          while (bis.read(buff) != -1) {
            os.write(buff, 0, buff.length);
            os.flush();
          }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (bis != null) {
            try {
              bis.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
        System.out.println("success");
		
	}
	
}
