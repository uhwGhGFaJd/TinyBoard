package onion.tinyboard.service;


import onion.tinyboard.domain.ChangePassword;
import onion.tinyboard.domain.ServerConfig;

import java.util.List;

public interface ManageService {

    String getServerConfigValue(int id);

    void changeServerState(String mode);

    void changePostingState(String mode);

    void deleteAllArticle();

    List<ServerConfig> getServerConfig();

    int getServerState();

    void changeManagePassword(ChangePassword changePassword);
}
