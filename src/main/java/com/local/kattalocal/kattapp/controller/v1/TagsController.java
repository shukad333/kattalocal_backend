package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Tag;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TagsController {

  @GetMapping(value = "v1/tags")
  ResponseEntity<List<Tag>> getTagsWithName(@PathVariable("tagName") String tagName) {
    log.debug("getting tags with name {}",tagName);
    return null;
  }

}
