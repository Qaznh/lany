package com.cn.wx.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@ResponseBody
    @RequestMapping("/upload")
	 public boolean upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) 
			 throws IOException {
       // System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
     
        //String id = request.getParameter("id");
        //System.out.println(id);
        if(!file.isEmpty()) {
         
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
         
            if (type != null) {
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = "Q:\\Users\\Aqzh\\git\\lany\\src\\main\\webapp\\Image\\news_image\\";
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath + trueFileName; 
                    file.transferTo(new File(path));
                }
               }
        }
		return true;
}
	
}

