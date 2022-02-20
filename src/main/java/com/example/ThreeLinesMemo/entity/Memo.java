package com.example.ThreeLinesMemo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Memo {
    private int memo_id;
    private String memo_title;
    private String memo_contents;
    private LocalDateTime created;
}
