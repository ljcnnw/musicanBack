package com.musican.sysUser.web;

import com.musican.Utils.FtpUtils;
import com.musican.Utils.ReturnMessage;
import com.musican.sysUser.model.SysUser;
import com.musican.sysUser.service.ISysUserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    ISysUserService sysUserService;
    @Autowired
    FtpUtils ftpUtils;

    @GetMapping("findList")
    public List<SysUser> findList() {
        return sysUserService.findList();
    }

    @PostMapping("login")
    public ReturnMessage login(@RequestBody SysUser sysUser) {
        return sysUserService.login(sysUser);
    }

    @PostMapping("upload")
    public ReturnMessage upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        ReturnMessage returnMessage = new ReturnMessage();
        String fileName = file.getOriginalFilename();
        long size = file.getSize();
        if (size > 5000000) {
            returnMessage.setSuccess(false);
            returnMessage.setCode(500);
            returnMessage.setMessage("图片大小不得超过5M");
            return returnMessage;
        }
        InputStream inputStream = file.getInputStream();
        String filePath = null;
        Boolean flag = ftpUtils.uploadFile(fileName, inputStream);
        if (flag = true) {
            filePath = ftpUtils.FTP_BASEPATH + fileName;
            returnMessage.setData(filePath);
        } else {
            returnMessage.setSuccess(false);
            returnMessage.setCode(500);
        }
        return returnMessage;
    }

    @GetMapping("checkUserName")
    public ReturnMessage checkUserName(String userName) {
        ReturnMessage message = sysUserService.checkUserName(userName);
        return message;
    }

    @PostMapping("regist")
    public ReturnMessage regist(SysUser sysUser) {
        return sysUserService.regist(sysUser);
    }

    @PostMapping("email")
    public void email() throws Exception{
        sysUserService.sendEmail();
    }

}
