package com.oracle.plus.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")   //表示映射的是哪个表
public class User implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO) //表示是主键
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username") //表示映射哪个字段
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    @TableField(value = "deleted")
    @TableLogic  //代表逻辑删除的字段
    private Integer deleted;

    private static final long serialVersionUID = 1L;
}