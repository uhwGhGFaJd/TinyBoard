package onion.tinyboard.service.impl;

import onion.tinyboard.domain.GetDeleteThreadInfo;
import onion.tinyboard.mapper.ThreadMapper;
import onion.tinyboard.service.DeleteThreadService;
import org.springframework.stereotype.Service;

@Service
public class DeleteThreadServiceImpl implements DeleteThreadService {

    private final ThreadMapper threadMapper;

    public DeleteThreadServiceImpl(ThreadMapper threadMapper) {
        this.threadMapper = threadMapper;
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
