package com.baoli.spring.common.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: common-demo
 * @description: BaseModel
 * @author: li baojian
 * @create: 2020-03-19 14:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public abstract class BaseModel<T extends BaseModel<T>> extends Model<T> {

    @TableId(value = "uuid",type = IdType.UUID)
    private String uuid;
    /**
     * 创建日期
     */
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @JSONField(serialize = true)
    private Date createDate;
    /**
     * 更新日期
     */
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;
    /**
     * 创建人
     */
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @JSONField(serialize = true)
    private String createUser;
    /**
     * 创建人名称
     */
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @JSONField(serialize = true)
    private String createUserName;
    /**
     * 更新人
     */
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    @JSONField(serialize = false)
    private String updateUser;
    /**
     * 更新人名称
     */
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    @JSONField(serialize = false)
    private String updateUserName;

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }
}
