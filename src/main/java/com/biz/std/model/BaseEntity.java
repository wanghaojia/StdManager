package com.biz.std.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * po基类
 * Created by haojia.wang on 2017/5/27
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable{

    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
