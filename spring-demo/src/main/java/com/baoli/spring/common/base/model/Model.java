package com.baoli.spring.common.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @program: common-demo
 * @description: Model
 * @author: li baojian
 * @create: 2020-03-19 14:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Model<T extends Model<T>> extends com.baomidou.mybatisplus.extension.activerecord.Model<T> {
}
