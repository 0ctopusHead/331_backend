package se331.lab.rest.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.rest.util.CloudStorageHelper;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorageHelper;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam(value = "file")MultipartFile file) throws IOException, ServletException{
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"imageupload-80919.appspot.com"));
    }
    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestParam(value = "image")MultipartFile file) throws  IOException, ServletException{
        return ResponseEntity.ok(this.cloudStorageHelper.getStorageFileDto(file,"imageupload-80919.appspot.com"));
    }
}
