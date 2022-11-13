package onion.tinyboard.repository;


import onion.tinyboard.domain.ChangePassword;
import onion.tinyboard.domain.ServerConfig;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/17
 * Github : https://github.com/uhwGhGFaJd
 */
@Mapper
@Repository
public interface ManageMapper {

    @Select("SELECT config_value FROM config WHERE id = #{id}")
    String getServerConfigValue(int id);

    void changeServerState(String mode);

    void changePostingState(String mode);

    @Delete("DELETE FROM articles")
    void deleteAllArticle();

    @Select("SELECT id, config_name, config_value FROM config")
    List<ServerConfig> getAllServerConfig();

    @Select("SELECT config_value FROM config WHERE config_name = 'server_disabled'")
    Boolean getServerState();

    @Update("UPDATE config SET config_value = #{newPassword} WHERE id = 3")
    void changeManagePassword(ChangePassword changePassword);

}
