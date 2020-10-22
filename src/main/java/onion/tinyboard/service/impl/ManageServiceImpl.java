package onion.tinyboard.service.impl;


import onion.tinyboard.domain.ChangePassword;
import onion.tinyboard.domain.ServerConfig;
import onion.tinyboard.mapper.ManageMapper;
import onion.tinyboard.service.ManageService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    private final ManageMapper manageMapper;

    public ManageServiceImpl(ManageMapper manageMapper) {
        this.manageMapper = manageMapper;
    }

    @Override
    public String getServerConfigValue(int id) {
        return manageMapper.getServerConfigValue(id);
    }

    @Override
    public void changeServerState(String mode) {
        manageMapper.changeServerState(mode);
    }

    @Override
    public void changePostingState(String mode) {
        manageMapper.changePostingState(mode);
    }

    @Override
    public void deleteAllArticle() {
        manageMapper.deleteAllArticle();
    }

    @Override
    public List<ServerConfig> getServerConfig() {
        return manageMapper.getAllServerConfig();
    }

    @Override
    public Boolean getServerState() {
        return manageMapper.getServerState();
    }

    @Override
    public void changeManagePassword(ChangePassword changePassword) {
        changePassword.setNewPassword(BCrypt.hashpw(changePassword.getNewPassword(), BCrypt.gensalt()));
        manageMapper.changeManagePassword(changePassword);
    }

}
