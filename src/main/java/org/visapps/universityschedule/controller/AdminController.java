package org.visapps.universityschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.visapps.universityschedule.dto.Result;
import org.visapps.universityschedule.service.AdminService;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Result> uploadSchedule(@RequestParam("schedule") MultipartFile file) {
        try{
            adminService.saveSchedule(file);
            return ResponseEntity.ok(Result.Success());
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(Result.Error("Unable to process schedule"));
        }
    }

}
