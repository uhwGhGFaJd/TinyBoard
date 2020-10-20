package onion.tinyboard.service;

import onion.tinyboard.domain.GetDeleteThreadInfo;
import onion.tinyboard.domain.ListThread;
import onion.tinyboard.domain.PostThread;

import java.util.List;
import java.util.Map;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
public interface ThreadService {

    void insertNewThread(PostThread postThread);

    Map<String, Object> getThreadInfo(int thread_id);

    List<ListThread> ListThread(Map<String, Object> data);

    int totalThreadCount();

    GetDeleteThreadInfo getDeleteThreadInfo(int thread_id);

    void deleteThread(int thread_id);
}
