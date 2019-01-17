package com.musican.sysUser.service;

import com.musican.Utils.ReturnMessage;
import com.musican.Utils.ServiceUtils;
import com.musican.Utils.StringUtils;
import com.musican.sysUser.dao.SysUserMapper;
import com.musican.sysUser.model.SysUser;
import com.musican.userInfo.service.IUserInfoService;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class SysUserService extends ServiceUtils<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    IUserInfoService userInfoService;

    @Override
    public List<SysUser> findList() {

        return sysUserMapper.findList();
    }

    @Override
    public ReturnMessage login(SysUser sysUser) {
        ReturnMessage returnMessage = new ReturnMessage();
        SysUser user = sysUserMapper.login(sysUser);
        if (user == null) {
            returnMessage.setMessage("用户名密码错误");
            returnMessage.setSuccess(false);
        } else {
            returnMessage.setSuccess(true);
            returnMessage.setData(user);
        }
        return returnMessage;
    }

    @Override
    public ReturnMessage regist(@RequestBody SysUser sysUser) {
        ReturnMessage message = new ReturnMessage(ReturnMessage.CODE_FIAL);
        if (!StringUtils.isNotBlanks(sysUser.getUserName())) {
            message.setMessage("用户名为空");
            return message;
        } else if (!StringUtils.isNotBlanks(sysUser.getUserPass())) {
            message.setMessage("密码为空");
            return message;
        } else if (sysUser.getUserInfo() == null || !StringUtils.isNotBlanks(sysUser.getUserInfo().getUserInfoEmail())) {
            message.setMessage("邮箱为空");
            return message;
        } else if (sysUser.getUserName().length() < 8) {
            message.setMessage("用户名长度不能小于8个字符");
            return message;
        } else if (sysUser.getUserName().length() > 20) {
            message.setMessage("用户名长度不能超过20个字符");
            return message;
        } else if (sysUser.getUserPass().length() < 8) {
            message.setMessage("密码长度不能小于8个字符");
            return message;
        } else {
            ReturnMessage m = checkUserName(sysUser.getUserName());
            if (!m.isSuccess()) {
                message.setMessage(m.getMessage());
                return message;
            }
            super.save(sysUser);
            sysUser.getUserInfo().setUserId(sysUser.getId());
            userInfoService.save(sysUser.getUserInfo());
            message.setSuccess(true);
            message.setCode(ReturnMessage.CODE_SUCCESS);
            message.setMessage("注册成功");
            return message;
        }
//        try {
//            super.save(sysUser);
//            sysUser.getUserInfo().setUserId(sysUser.getId());
//            if(sysUser.getUserInfo().getAddress().length != 0){
//                sysUser.getUserInfo().setUserInfoAddress(StringUtils.join(sysUser.getUserInfo().getAddress()));
//            }
//            userInfoService.save(sysUser.getUserInfo());
//            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_SUCCESS);
//            return returnMessage;
//        }catch (Exception e){
//            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_FIAL);
//            e.printStackTrace();
//            return returnMessage;
//        }
    }

    @Override
    public ReturnMessage checkUserName(String userName) {
        List<SysUser> list = sysUserMapper.getByUserName(userName);
        ReturnMessage message = new ReturnMessage();
        if (list == null || list.size() == 0) {
            message.setCode(ReturnMessage.CODE_SUCCESS);
            message.setSuccess(true);
        } else {
            message.setCode(ReturnMessage.CODE_FIAL);
            message.setSuccess(false);
            message.setMessage("用户名重复");
        }
        return message;
    }

    public ReturnMessage sendEmail() throws Exception{
        ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_FIAL);
        String email = "1444123370@qq.com";
        String email2 = "ws86cg38@163.com";
        String host = "smtp.qq.com";
        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", host);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证
        //QQ邮箱需要下面这段代码，163邮箱不需要
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 1.获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1444123370@qq.com", "effgitdwablqjdaj"); // 发件人邮箱账号、授权码
            }
        });
        // 2.创建邮件对象
        Message message = new MimeMessage(session);
        // 2.1设置发件人
        message.setFrom(new InternetAddress(email));
        // 2.2设置接收人
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email2));
        // 2.3设置邮件主题
        message.setSubject("账号激活");
        message.setContent("111111", "text/html;charset=UTF-8");
        Transport.send(message);
        return returnMessage;
    }

//    @Override
//    public ReturnMessage test() {
//        ReturnMessage returnMessage = new ReturnMessage();
//        returnMessage.setData(sysUserMapper.findAll());
//        return returnMessage;
//    }
}
