package com.qunar.fresh2018.spring.model;
import java.util.Date;

import lombok.Data;
import org.springframework.boot.orm.jpa.EntityScan;

@EntityScan
@Data public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String remark;
    private String gender;
    private String phone;
    private Integer usable;
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime ;
    private Date lastModified ;

}
