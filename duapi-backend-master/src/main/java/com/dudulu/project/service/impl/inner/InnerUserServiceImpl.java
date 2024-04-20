package com.dudulu.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dudulu.project.common.ErrorCode;
import com.dudulu.project.exception.BusinessException;
import com.dudulu.project.mapper.UserMapper;
import com.dudulu.yuapicommon.model.entity.User;
import com.dudulu.yuapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 内部用户服务实现类
 *
 * @author <a href="https://github.com/lidudulu"></a>
 * @from <a href="https://dudulu.icu"></a>
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
