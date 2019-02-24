package org.visapps.universityschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.visapps.universityschedule.service.AdminService;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/upload")
    public String uploadSchedule(@RequestParam("schedule") MultipartFile file) {
        try{
            adminService.saveSchedule(file);
            return "ok";
        }
        catch(Exception e){
            e.printStackTrace();
            return "failed to insert";
        }
    }

}
