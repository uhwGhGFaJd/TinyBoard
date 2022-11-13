package onion.tinyboard.repository;

import onion.tinyboard.domain.GetRepliesList;
import onion.tinyboard.domain.PostReply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Mapper
@Repository
public interface ThreadReplyMapper {

    @Select("SELECT reply_id, reply_nickname, reply_password, reply_content, DATE_FORMAT(reply_create_date,'%e %M %Y, %H:%i') reply_create_date " +
            "FROM thread_reply WHERE thread_id = #{thread_id} " +
            "ORDER BY reply_id ASC")
    List<GetRepliesList> getThreadRepliesList(int thread_id);

    @Insert("INSERT INTO thread_reply(thread_id, reply_nickname, reply_password, reply_content) VALUES " +
            "(#{thread_id}, #{nickname}, #{password}, #{content})")
    void insertThreadReply(PostReply postReply);

}

