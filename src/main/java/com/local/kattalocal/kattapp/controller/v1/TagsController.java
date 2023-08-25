package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagsController {

  ResponseEntity<List<Tag>> getTagsWithName() {

    return null;

  }

}
