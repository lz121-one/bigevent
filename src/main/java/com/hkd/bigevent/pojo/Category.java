package com.hkd.bigevent.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;
    private String category_name;
    private String category_alias;
    private Integer create_user;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
