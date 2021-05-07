package de.swapab.csvupload.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CsvUploadController {
    @PostMapping(value = "/api/upload/csv")
    public String upload(@RequestParam(value = "file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "success";
    }
}
