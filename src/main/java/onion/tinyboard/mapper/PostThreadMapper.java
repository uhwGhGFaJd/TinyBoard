package onion.tinyboard.mapper;

import onion.tinyboard.domain.PostThread;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Mapper
@Repository
public interface PostThreadMapper {

    @Insert("INSERT INTO threads(thread_nickname, thread_password, thread_content) VALUES (#{nickname}, #{password}, #{content})")
    void insertNewThread(PostThread postThread);

}
