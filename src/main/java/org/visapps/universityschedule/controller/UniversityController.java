package org.visapps.universityschedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.visapps.universityschedule.dto.Class;
import org.visapps.universityschedule.dto.Response;
import org.visapps.universityschedule.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("university")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/classes")
    @CrossOrigin
    public ResponseEntity<Response> classes(@RequestParam(value="q") String query) {
        try{
            List<Class> results = universityService.getClasses(query);
            return ResponseEntity.ok(Response.Success(results));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(Response.Error());
        }
    }
}
