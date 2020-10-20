package onion.tinyboard.service.impl;

import onion.tinyboard.domain.PostThread;
import onion.tinyboard.mapper.ThreadMapper;
import onion.tinyboard.service.PostThreadService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PostThreadServiceImpl implements PostThreadService {

    private final ThreadMapper threadMapper;

    public PostThreadServiceImpl(ThreadMapper threadMapper) {
        this.threadMapper = threadMapper;
    }


    @Override
    public void insertNewThread(PostThread postThread) {
        if (postThread.getNickname() == null || postThread.getNickname().trim().length() == 0) {
            postThread.setNickname("Anonymous");
        }
        postThread.setPassword(BCrypt.hashpw(postThread.getPassword(), BCrypt.gensalt()));
        threadMapper.insertNewThread(postThread);
    }
}
