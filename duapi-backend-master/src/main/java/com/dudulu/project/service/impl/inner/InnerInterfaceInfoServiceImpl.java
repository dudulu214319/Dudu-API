package com.dudulu.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dudulu.project.common.ErrorCode;
import com.dudulu.project.exception.BusinessException;
import com.dudulu.project.mapper.InterfaceInfoMapper;
import com.dudulu.yuapicommon.model.entity.InterfaceInfo;
import com.dudulu.yuapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 内部接口服务实现类
 *
 * @author <a href="https://github.com/lidudulu"></a>
 * @from <a href="https://dudulu.icu"></a>
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {


    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }

}
