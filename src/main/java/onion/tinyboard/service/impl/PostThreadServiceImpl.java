package onion.tinyboard.service.impl;

import onion.tinyboard.domain.PostThread;
import onion.tinyboard.mapper.PostThreadMapper;
import onion.tinyboard.service.PostThreadService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PostThreadServiceImpl implements PostThreadService {

    private final PostThreadMapper postThreadMapper;

    public PostThreadServiceImpl(PostThreadMapper postThreadMapper) {
        this.postThreadMapper = postThreadMapper;
    }

    @Override
    public void insertNewThread(PostThread postThread) {
        if (postThread.getNickname() == null || postThread.getNickname().trim().length() == 0) {
            postThread.setNickname("Anonymous");
        }
        postThread.setPassword(BCrypt.hashpw(postThread.getPassword(), BCrypt.gensalt()));
        postThreadMapper.insertNewThread(postThread);
    }
}
