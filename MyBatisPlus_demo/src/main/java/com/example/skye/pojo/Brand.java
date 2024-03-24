package com.example.skye.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("brand")
public class Brand {

    //对应数据库的主键（uuid、自增id、雪花算法、redis、zookeeper）
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String brandName;
    private String companyName;
    private Integer ordered;
    private Integer status;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;

    //字段添加填充内容，编写一个处理器处理注解
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
