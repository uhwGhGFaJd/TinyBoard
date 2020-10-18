package onion.tinyboard.mapper;


import onion.tinyboard.domain.ListThread;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Mapper
@Repository
public interface ListOfThreadMapper {

    @Select("SELECT thread_id, thread_nickname, thread_content, DATE_FORMAT(thread_create_date,'%e %M %Y, %H:%i') thread_create_date FROM threads " +
            "ORDER BY thread_id DESC limit #{startPage}, #{rowNum}")
    List<ListThread> ListThread(Map<String, Object> data);

    @Select("SELECT COUNT(*) FROM threads")
    int totalThreadCount();
}
