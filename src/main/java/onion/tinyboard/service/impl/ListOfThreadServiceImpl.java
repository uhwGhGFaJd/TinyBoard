package onion.tinyboard.service.impl;


import onion.tinyboard.domain.ListThread;
import onion.tinyboard.mapper.ThreadMapper;
import onion.tinyboard.service.ListOfThreadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ListOfThreadServiceImpl implements ListOfThreadService {

    private final ThreadMapper threadMapper;

    public ListOfThreadServiceImpl(ThreadMapper threadMapper) {
        this.threadMapper = threadMapper;
    }

    @Override
    public List<ListThread> ListThread(Map<String, Object> data) {
        return threadMapper.ListThread(data);
    }

    @Override
    public int totalThreadCount() {
        return threadMapper.totalThreadCount();
    }


}
