package com.musican.sysUser.web;

import com.musican.sysUser.model.SysUser;
import com.musican.sysUser.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    ISysUserService sysUserService;

    @GetMapping("findList")
    public List<SysUser> findList(){
        return sysUserService.findList();
    }
}
