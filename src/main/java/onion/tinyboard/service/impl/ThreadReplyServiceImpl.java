package onion.tinyboard.service.impl;

import onion.tinyboard.domain.GetRepliesList;
import onion.tinyboard.domain.PostReply;
import onion.tinyboard.repository.ThreadReplyMapper;
import onion.tinyboard.service.ThreadReplyService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Service
public class ThreadReplyServiceImpl implements ThreadReplyService {

    private final ThreadReplyMapper threadReplyMapper;

    public ThreadReplyServiceImpl(ThreadReplyMapper threadReplyMapper) {
        this.threadReplyMapper = threadReplyMapper;
    }

    @Override
    public List<GetRepliesList> getThreadRepliesList(int thread_id) {
        return threadReplyMapper.getThreadRepliesList(thread_id);
    }

    @Override
    public void insertThreadReply(PostReply postReply) {
        if (postReply.getNickname() == null || postReply.getNickname().trim().length() == 0) {
            postReply.setNickname("Anonymous");
        }
        postReply.setPassword(BCrypt.hashpw(postReply.getPassword(), BCrypt.gensalt()));
        threadReplyMapper.insertThreadReply(postReply);
    }
}
