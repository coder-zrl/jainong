package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.ProductStorageEntity;

import java.util.Map;

/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-12 23:56:03
 */
public interface ProductStorageService extends IService<ProductStorageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

