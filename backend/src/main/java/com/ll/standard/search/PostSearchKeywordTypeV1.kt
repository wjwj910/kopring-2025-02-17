package com.ll.standard.search;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PostSearchKeywordTypeV1 {
    all("all"),
    title("title"),
    content("content"),
    author("author");

    private final String value;
}
