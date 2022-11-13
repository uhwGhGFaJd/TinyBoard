package onion.tinyboard.repository;

import onion.tinyboard.domain.GetDeleteThreadInfo;
import onion.tinyboard.domain.GetThreadInfo;
import onion.tinyboard.domain.ListThread;
import onion.tinyboard.domain.PostThread;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Mapper
@Repository
public interface ThreadMapper {

    @Select("SELECT thread_id, thread_password FROM threads WHERE thread_id = #{thread_id}")
    GetDeleteThreadInfo getDeleteThreadInfo(int thread_id);

    @Delete("DELETE FROM threads WHERE thread_id = #{thread_id}")
    void deleteThread(int thread_id);

    @Select("SELECT thread_id, thread_nickname, thread_content, DATE_FORMAT(thread_create_date,'%e %M %Y, %H:%i') thread_create_date, " +
            "(SELECT COUNT(*) FROM thread_reply WHERE thread_id=th.thread_id) AS thread_reply_count " +
            "FROM threads th " +
            "ORDER BY thread_id DESC limit #{startPage}, #{rowNum}")
    List<ListThread> ListThread(Map<String, Object> data);

    @Select("SELECT COUNT(*) FROM threads")
    int totalThreadCount();

    @Insert("INSERT INTO threads(thread_nickname, thread_password, thread_content) VALUES (#{nickname}, #{password}, #{content})")
    void insertNewThread(PostThread postThread);

    @Select("SELECT thread_id, thread_nickname, thread_content, DATE_FORMAT(thread_create_date,'%e %M %Y, %H:%i') thread_create_date " +
            "FROM threads WHERE thread_id = #{thread_id}")
    GetThreadInfo getThreadInfo(int thread_id);

}
