package onion.tinyboard.mapper;

import onion.tinyboard.domain.GetRepliesList;
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

    @Select("SELECT")
    List<GetRepliesList> getThreadRepliesList(int thread_id);
}

