package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.ProductionPlanEntity;

import java.util.Map;

/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-13 01:23:07
 */
public interface ProductionPlanService extends IService<ProductionPlanEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

