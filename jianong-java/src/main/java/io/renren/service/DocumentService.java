package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.DocumentEntity;

import java.util.Map;

/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-12 23:56:04
 */
public interface DocumentService extends IService<DocumentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

