package onion.tinyboard.service.impl;


import onion.tinyboard.domain.ListThread;
import onion.tinyboard.mapper.ListOfThreadMapper;
import onion.tinyboard.service.ListOfThreadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ListOfThreadServiceImpl implements ListOfThreadService {

    private final ListOfThreadMapper listOfThreadMapper;

    public ListOfThreadServiceImpl(ListOfThreadMapper listOfThreadMapper) {
        this.listOfThreadMapper = listOfThreadMapper;
    }

    @Override
    public List<ListThread> ListThread(Map<String, Object> data) {
        return listOfThreadMapper.ListThread(data);
    }

    @Override
    public int totalThreadCount() {
        return listOfThreadMapper.totalThreadCount();
    }


}
