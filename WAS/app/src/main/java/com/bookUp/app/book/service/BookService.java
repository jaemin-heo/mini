package com.bookUp.app.book.service;

import com.bookUp.app.book.mapper.BookMapper;
import com.bookUp.app.book.vo.BookVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;

    public List<BookVo> selectList() {
        return bookMapper.selectList();
    }

    public BookVo selectOne(String id) {
        return bookMapper.selectOne(id);
    }

    public int insert(BookVo bvo) {
        return bookMapper.insert(bvo);
    }

    public int update(BookVo bvo) {
        return bookMapper.update(bvo);
    }

    public int delete(BookVo bvo) {
        return bookMapper.delete(bvo);
    }
}
