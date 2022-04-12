package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.ProductionPlanDao;
import io.renren.entity.ProductionPlanEntity;
import io.renren.service.ProductionPlanService;


@Service("productionPlanService")
public class ProductionPlanServiceImpl extends ServiceImpl<ProductionPlanDao, ProductionPlanEntity> implements ProductionPlanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductionPlanEntity> page = this.page(
                new Query<ProductionPlanEntity>().getPage(params),
                new QueryWrapper<ProductionPlanEntity>()
        );

        return new PageUtils(page);
    }

}