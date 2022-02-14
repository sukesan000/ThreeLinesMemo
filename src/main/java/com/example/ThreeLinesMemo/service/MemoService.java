package com.example.ThreeLinesMemo.service;

import com.example.ThreeLinesMemo.entity.Memo;

import java.util.List;

public interface MemoService {
    void save(Memo memo);
    void deleteOne(int id);
    List<Memo> getAll();
}
