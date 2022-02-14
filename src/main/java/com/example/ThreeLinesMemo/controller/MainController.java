package com.example.ThreeLinesMemo.controller;

import com.example.ThreeLinesMemo.entity.Memo;
import com.example.ThreeLinesMemo.form.MemoForm;
import com.example.ThreeLinesMemo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class MainController {
    @Autowired
    MemoService memoService;

    @GetMapping("/main")
    public String main(MemoForm memoForm, Model model){
        model.addAttribute("memoList", memoService.getAll());
        return "main";
    }

    @PostMapping("/postMemo")
    public String postMemo(@Validated MemoForm memoForm, BindingResult result, Model model){
        if(result.hasErrors()){
            return "main";
        }
        Memo memo = new Memo();
        memo.setMemo_title(memoForm.getMemo_title());
        memo.setMemo_contents(memoForm.getMemo_contents());
        memo.setCreated(LocalDateTime.now());
        memoService.save(memo);
        return "redirect:/main";
    }

    @PostMapping("/deleteOne")
    public void deleteOne(MemoForm memoForm, BindingResult result, Model model){
        Memo memo = new Memo();
        memoService.deleteOne(memoForm.getId());
    }
}
