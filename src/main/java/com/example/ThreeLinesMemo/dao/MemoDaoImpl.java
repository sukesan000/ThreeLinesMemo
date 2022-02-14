package com.example.ThreeLinesMemo.dao;

import com.example.ThreeLinesMemo.entity.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoDaoImpl implements MemoDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemoDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertMemo(Memo memo) {
        jdbcTemplate.update("insert into memo(memo_title, memo_contents, created) values(?, ?, ?)",
                memo.getMemo_title(),memo.getMemo_contents(), memo.getCreated());
    }

    @Override
    public void deleteOneMemo(int id){
        jdbcTemplate.update("delete from memo where id = ?", id);
    }

    @Override
    public List<Memo> getAll() {
        String sql = "select * from memo";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        List<Memo> list = new ArrayList<Memo>();
        for(Map<String, Object> result: resultList){
            Memo memo = new Memo();
            memo.setId((int)result.get("id"));
            memo.setMemo_title((String)result.get("memo_title"));
            memo.setMemo_contents((String)result.get("memo_contents"));
            memo.setCreated((LocalDateTime) result.get("created"));
            list.add(memo);
        }
        return list;
    }
}
