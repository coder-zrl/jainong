package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.ProductOutboundDao;
import io.renren.entity.ProductOutboundEntity;
import io.renren.service.ProductOutboundService;


@Service("productOutboundService")
public class ProductOutboundServiceImpl extends ServiceImpl<ProductOutboundDao, ProductOutboundEntity> implements ProductOutboundService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductOutboundEntity> page = this.page(
                new Query<ProductOutboundEntity>().getPage(params),
                new QueryWrapper<ProductOutboundEntity>()
        );

        return new PageUtils(page);
    }

}