package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Getter
@Setter
public class GetRepliesList {
    private int reply_id;
    private String reply_nickname;
    private String reply_content;
    private String reply_create_date;
}
