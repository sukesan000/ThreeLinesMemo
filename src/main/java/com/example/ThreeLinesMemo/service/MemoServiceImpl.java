package com.example.ThreeLinesMemo.service;

import com.example.ThreeLinesMemo.dao.MemoDao;
import com.example.ThreeLinesMemo.entity.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {
    private final MemoDao dao;

    @Autowired
    MemoServiceImpl(MemoDao dao){
        this.dao = dao;
    }

    @Override
    public void save(Memo memo){
        dao.insertMemo(memo);
    }

    @Override
    public void deleteOne(int id){
        dao.deleteOneMemo(id);
    }

    @Override
    public List<Memo> getAll(){
        return dao.getAll();
    }
}
