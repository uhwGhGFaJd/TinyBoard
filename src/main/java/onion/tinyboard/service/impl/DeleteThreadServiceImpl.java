package onion.tinyboard.service.impl;

import onion.tinyboard.domain.GetDeleteThreadInfo;
import onion.tinyboard.mapper.DeleteThreadMapper;
import onion.tinyboard.service.DeleteThreadService;
import org.springframework.stereotype.Service;

@Service
public class DeleteThreadServiceImpl implements DeleteThreadService {

    private final DeleteThreadMapper deleteThreadMapper;

    public DeleteThreadServiceImpl(DeleteThreadMapper deleteThreadMapper) {
        this.deleteThreadMapper = deleteThreadMapper;
    }

    @Override
    public GetDeleteThreadInfo getDeleteThreadInfo(int thread_id) {
        return deleteThreadMapper.getDeleteThreadInfo(thread_id);
    }

    @Override
    public void deleteThread(int thread_id) {
        deleteThreadMapper.deleteThread(thread_id);
    }
}
