package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.SuppliesOutboundDao;
import io.renren.entity.SuppliesOutboundEntity;
import io.renren.service.SuppliesOutboundService;


@Service("suppliesOutboundService")
public class SuppliesOutboundServiceImpl extends ServiceImpl<SuppliesOutboundDao, SuppliesOutboundEntity> implements SuppliesOutboundService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuppliesOutboundEntity> page = this.page(
                new Query<SuppliesOutboundEntity>().getPage(params),
                new QueryWrapper<SuppliesOutboundEntity>()
        );

        return new PageUtils(page);
    }

}