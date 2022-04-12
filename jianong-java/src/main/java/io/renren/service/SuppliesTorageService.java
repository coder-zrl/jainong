package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.SuppliesTorageEntity;

import java.util.Map;

/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-12 23:56:04
 */
public interface SuppliesTorageService extends IService<SuppliesTorageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

