package com.spotify.springBootExample.util;

import org.springframework.context.annotation.Bean;

public interface SpamDetector {
  boolean containsSpam(String value);
}
