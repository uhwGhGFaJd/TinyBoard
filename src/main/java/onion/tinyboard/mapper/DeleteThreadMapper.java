package onion.tinyboard.mapper;

import onion.tinyboard.domain.GetDeleteThreadInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Mapper
@Repository
public interface DeleteThreadMapper {

    @Select("SELECT thread_id, thread_password FROM threads WHERE thread_id = #{thread_id}")
    GetDeleteThreadInfo getDeleteThreadInfo(int thread_id);

    @Delete("DELETE FROM threads WHERE thread_id = #{thread_id}")
    void deleteThread(int thread_id);

}
