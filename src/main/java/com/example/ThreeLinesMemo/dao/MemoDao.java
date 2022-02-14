package com.example.ThreeLinesMemo.dao;

import com.example.ThreeLinesMemo.entity.Memo;

import java.util.List;

public interface MemoDao {
    void insertMemo(Memo memo);
    void deleteOneMemo(int id);
    List<Memo> getAll();
}
