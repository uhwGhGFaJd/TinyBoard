package onion.tinyboard.service.impl;

import onion.tinyboard.mapper.ThreadMapper;
import onion.tinyboard.mapper.ThreadReplyMapper;
import onion.tinyboard.service.ViewThreadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Service
public class ViewThreadServiceImpl implements ViewThreadService {

    private final ThreadMapper threadMapper;
    private final ThreadReplyMapper threadReplyMapper;

    public ViewThreadServiceImpl(ThreadMapper threadMapper, ThreadReplyMapper threadReplyMapper) {
        this.threadMapper = threadMapper;
        this.threadReplyMapper = threadReplyMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getThreadInfo(int thread_id) {
        Map<String, Object> data = new HashMap<>();

        data.put("threadInfo", threadMapper.getThreadInfo(thread_id));
        //data.put("replies", threadReplyMapper.getThreadRepliesList(thread_id));

        return data;
    }
}
