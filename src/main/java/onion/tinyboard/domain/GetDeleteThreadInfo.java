package onion.tinyboard.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetDeleteThreadInfo {
    private int thread_id;
    private String thread_password;
}
