package onion.tinyboard.service;

import onion.tinyboard.domain.GetDeleteThreadInfo;


public interface DeleteThreadService {

    GetDeleteThreadInfo getDeleteThreadInfo(int thread_id);

    void deleteThread(int thread_id);
}
