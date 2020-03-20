package com.baoli.spring.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: common-demo
 * @description: mybatis plus自动填充字段值
 * @author: li baojian
 * @create: 2020-03-19 16:21
 */
@Component
public class BaseModelMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasGetter("createUser")){
            Object createUser = metaObject.getValue("createUser");
            if(null ==createUser){
                setInsertFieldValByName("createUser","123456",metaObject);
            }
        }
        if(metaObject.hasGetter("createUserName")){
            Object createUser = metaObject.getValue("createUserName");
            if(null ==createUser){
                setInsertFieldValByName("createUserName","haha",metaObject);
            }
        }
        if(metaObject.hasGetter("createDate")){
            Object createUser = metaObject.getValue("createDate");
            if(null ==createUser){
                setInsertFieldValByName("createDate",new Date(),metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(metaObject.hasGetter("updateUser")){
            Object createUser = metaObject.getValue("updateUser");
            if(null ==createUser){
                setUpdateFieldValByName("updateUser","123456",metaObject);
            }
        }
        if(metaObject.hasGetter("updateUserName")){
            Object createUser = metaObject.getValue("updateUserName");
            if(null ==createUser){
                setUpdateFieldValByName("updateUserName","hehe",metaObject);
            }
        }
        if(metaObject.hasGetter("updateDate")){
            Object createUser = metaObject.getValue("updateDate");
            if(null ==createUser){
                setUpdateFieldValByName("updateDate",new Date(),metaObject);
            }
        }

    }
}
