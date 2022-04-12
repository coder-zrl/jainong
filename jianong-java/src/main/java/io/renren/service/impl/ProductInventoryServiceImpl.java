package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.ProductInventoryDao;
import io.renren.entity.ProductInventoryEntity;
import io.renren.service.ProductInventoryService;


@Service("productInventoryService")
public class ProductInventoryServiceImpl extends ServiceImpl<ProductInventoryDao, ProductInventoryEntity> implements ProductInventoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductInventoryEntity> page = this.page(
                new Query<ProductInventoryEntity>().getPage(params),
                new QueryWrapper<ProductInventoryEntity>()
        );

        return new PageUtils(page);
    }

}