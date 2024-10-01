package com.hkd.bigevent.pojo;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    @JsonIgnore//当将返回的数据转换为json字符串时，忽略该字段
    private String password;
    private String nickname;
    private String email;
    private String user_pic;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
