package com.local.kattalocal.kattapp.controller.v1;

import com.amazonaws.HttpMethod;
import com.local.kattalocal.kattapp.service.AwsS3Service;
import java.net.URL;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

  private AwsS3Service awsS3Service;

  @Autowired
  public DocumentController(AwsS3Service awsS3Service) {
    this.awsS3Service = awsS3Service;
  }

  @GetMapping("v1/documents/upload-url")
  public ResponseEntity<String> generateUploadUrl(@RequestParam("fileName") String fileName) {
    //TODO - Change the bucket below to be read from env
    return ResponseEntity.ok(
        awsS3Service.generatePreSignedUrl(fileName, "kattalocal",
            HttpMethod.PUT));

  }

  @GetMapping("v1/documents/{documentId}")
  public ResponseEntity<URL> getUrl(@PathVariable("documentId") String documentName) {
    return ResponseEntity.ok(awsS3Service.getUrlFromFile(documentName));
  }

}
