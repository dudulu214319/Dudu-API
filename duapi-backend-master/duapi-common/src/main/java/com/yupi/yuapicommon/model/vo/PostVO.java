package com.dudulu.yuapicommon.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.dudulu.yuapicommon.model.entity.Post;

/**
 * 帖子视图
 *
 * @author <a href="https://github.com/lidudulu"></a>
 * @from <a href="https://dudulu.icu"></a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostVO extends Post {

    /**
     * 是否已点赞
     */
    private Boolean hasThumb;

    private static final long serialVersionUID = 1L;
}