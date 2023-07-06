package com.example.demo.repository;

import com.example.demo.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    private static Map<Integer, Board> list=new HashMap<>();
    private static int sequence=0;

    public void save(Board board){
        board.setId(++sequence);
        list.put(board.getId(), board);
    }
    public void delete(int id){
        list.remove(id);
    }
    public List<Board> findAll() {
        return new ArrayList<>(list.values());
    }
    public void edit(int id, Board board){
        list.put(id, board);
    }
    public Board findById(int id) {
        return list.get(id);
    }
}
