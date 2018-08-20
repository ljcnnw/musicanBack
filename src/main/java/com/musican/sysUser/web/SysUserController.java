package com.musican.sysUser.web;

import com.musican.Utils.ReturnMessage;
import com.musican.sysUser.model.SysUser;
import com.musican.sysUser.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("login")
    public ReturnMessage login(@RequestBody SysUser sysUser){
        return sysUserService.login(sysUser);
    }

}
