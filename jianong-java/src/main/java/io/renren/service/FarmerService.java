package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.FarmerEntity;

import java.util.Map;

/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-12 23:56:04
 */
public interface FarmerService extends IService<FarmerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

