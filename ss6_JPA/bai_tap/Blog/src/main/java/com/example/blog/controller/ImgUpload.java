package com.example.blog.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImgUpload {
    @RequestMapping(value = "getImg/{img}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImg(@PathVariable("img")String img){
        if (!img.equals("") || img!=null){
            try {
                Path filename= Paths.get("upload",img);
                byte[] buffer= Files.readAllBytes(filename);
                ByteArrayResource byteArrayResource=new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/mp4"))
                        .body(byteArrayResource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
