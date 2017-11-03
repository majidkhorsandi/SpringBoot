package com.spotify.springBootExample.util;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleSpamDetector {
  private List<String> spamWords = new ArrayList<String>();

  public SimpleSpamDetector() throws IOException {
    FileInputStream fis = new FileInputStream(new File(""));
    this.spamWords = IOUtils.readLines(fis);
  }

  public boolean containsSpam(String value) {
    return spamWords.stream().anyMatch(spam -> value.toLowerCase().contains(spam));
  }

}
