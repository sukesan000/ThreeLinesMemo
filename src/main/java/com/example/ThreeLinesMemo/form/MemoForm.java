package com.example.ThreeLinesMemo.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MemoForm {
    private int memo_id;
    @NotNull
    private String memo_title;
    @NotNull
    private String memo_contents;
}
