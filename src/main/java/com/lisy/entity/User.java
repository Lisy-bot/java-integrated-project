package com.lisy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String mobile;
    private String email;
    private String password;
    private Integer insert_uid;
    private Date insert_time;
    private Date update_time;
    private Integer is_del;
    private Integer is_job;
    private String mcode;
    private Date send_time;
    private Integer version;
}
