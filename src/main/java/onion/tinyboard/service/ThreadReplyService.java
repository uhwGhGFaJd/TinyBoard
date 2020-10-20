package onion.tinyboard.service;

import onion.tinyboard.domain.GetRepliesList;
import onion.tinyboard.domain.PostReply;

import java.util.List;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
public interface ThreadReplyService {

    List<GetRepliesList> getThreadRepliesList(int thread_id);

    void insertThreadReply(PostReply postReply);


}
