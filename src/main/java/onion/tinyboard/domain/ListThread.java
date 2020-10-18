package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListThread {
    private int thread_id;
    private String thread_nickname, thread_content, thread_create_date;
}
