package com.bookUp.app.book.mapper;

import com.bookUp.app.book.vo.BookVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("""
            SELECT ID, NAME, DESCRIPTION, DEL_YN
            FROM BOOK
            WHERE DEL_YN = 'N'
            ORDER BY ID DESC
            """)
    List<BookVo> selectList();

    @Select("""
            SELECT ID, NAME, DESCRIPTION, DEL_YN
            FROM BOOK
            WHERE ID = #{id}
            """)
    BookVo selectOne(String id);

    @Insert("""
            INSERT INTO BOOK (NAME, DESCRIPTION)
            VALUES(#{name}, #{description})
            """)
    int insert(BookVo bvo);

    @Update("""
            UPDATE BOOK
            SET NAME = #{name},
            DESCRIPTION = #{description}
            WHERE ID = #{id}
            """)
    int update(BookVo bvo);

    @Update("""
            UPDATE BOOK
            SET DEL_YN = 'Y'
            WHERE ID = #{id}
            """)
    int delete(BookVo bvo);
}
