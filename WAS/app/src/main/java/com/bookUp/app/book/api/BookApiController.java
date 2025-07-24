package com.bookUp.app.book.api;

import com.bookUp.app.book.service.BookService;
import com.bookUp.app.book.vo.BookVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookApiController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookVo>> selectList(){
        List<BookVo> bvo = bookService.selectList();
        System.out.println("bvo = " + bvo);
        return ResponseEntity.ok().body(bvo);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookVo> selectOne(@PathVariable String id){
        BookVo bvo = bookService.selectOne(id);
        return ResponseEntity.ok().body(bvo);
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody BookVo bvo){
        int result = bookService.insert(bvo);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody BookVo bvo){
        int result = bookService.update(bvo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody BookVo bvo){
        int result = bookService.delete(bvo);
        return ResponseEntity.ok().build();
    }
}
