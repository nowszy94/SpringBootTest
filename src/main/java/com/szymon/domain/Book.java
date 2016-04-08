package com.szymon.domain;

import lombok.Builder;
import lombok.Data;

/**
 * Created by szymon.nowak on 04.04.2016.
 */
@Data
@Builder
public class Book {

    private final String title;
    private final String author;
    private int pages;
}
