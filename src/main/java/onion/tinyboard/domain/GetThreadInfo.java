package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by uhwGhGFaJd@protonmail.com on 2020/10/19
 * Github       : https://github.com/uhwGhGFaJd
 */
@Getter
@Setter
public class GetThreadInfo {
    private int thread_id;
    private String thread_nickname;
    private String thread_content;
    private String thread_create_date;
}
