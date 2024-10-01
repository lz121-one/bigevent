package com.hkd.bigevent.pojo;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String cover_img;
    private String state;
    private Integer category_id;
    private Integer create_user;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
