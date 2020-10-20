package onion.tinyboard.service.impl;

import onion.tinyboard.domain.GetDeleteThreadInfo;
import onion.tinyboard.domain.ListThread;
import onion.tinyboard.domain.PostThread;
import onion.tinyboard.mapper.ThreadMapper;
import onion.tinyboard.mapper.ThreadReplyMapper;
import onion.tinyboard.service.ThreadService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    private final ThreadMapper threadMapper;
    private final ThreadReplyMapper threadReplyMapper;

    public ThreadServiceImpl(ThreadMapper threadMapper, ThreadReplyMapper threadReplyMapper) {
        this.threadMapper = threadMapper;
        this.threadReplyMapper = threadReplyMapper;
    }

    @Override
    public void insertNewThread(PostThread postThread) {
        if (postThread.getNickname() == null || postThread.getNickname().trim().length() == 0) {
            postThread.setNickname("Anonymous");
        }
        postThread.setPassword(BCrypt.hashpw(postThread.getPassword(), BCrypt.gensalt()));
        threadMapper.insertNewThread(postThread);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getThreadInfo(int thread_id) {
        Map<String, Object> data = new HashMap<>();
        data.put("threadInfo", threadMapper.getThreadInfo(thread_id));
        data.put("replies", threadReplyMapper.getThreadRepliesList(thread_id));
        return data;
    }

    @Override
    public List<ListThread> ListThread(Map<String, Object> data) {
        return threadMapper.ListThread(data);
    }

    @Override
    public int totalThreadCount() {
        return threadMapper.totalThreadCount();
    }

    @Override
    public GetDeleteThreadInfo getDeleteThreadInfo(int thread_id) {
        return threadMapper.getDeleteThreadInfo(thread_id);
    }

    @Override
    public void deleteThread(int thread_id) {
        threadMapper.deleteThread(thread_id);
    }
}
