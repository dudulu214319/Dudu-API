package com.dudulu.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dudulu.springbootinit.model.entity.InterfaceInfo;

/**
* @author 19263
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-03-18 16:49:00
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}