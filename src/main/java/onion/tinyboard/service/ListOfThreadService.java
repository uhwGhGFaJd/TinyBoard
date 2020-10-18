package onion.tinyboard.service;


import onion.tinyboard.domain.ListThread;

import java.util.List;
import java.util.Map;

public interface ListOfThreadService {

    List<ListThread> ListThread(Map<String, Object> data);

    int totalThreadCount();
}
