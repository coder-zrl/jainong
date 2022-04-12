package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.ProductStorageDao;
import io.renren.entity.ProductStorageEntity;
import io.renren.service.ProductStorageService;


@Service("productStorageService")
public class ProductStorageServiceImpl extends ServiceImpl<ProductStorageDao, ProductStorageEntity> implements ProductStorageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductStorageEntity> page = this.page(
                new Query<ProductStorageEntity>().getPage(params),
                new QueryWrapper<ProductStorageEntity>()
        );

        return new PageUtils(page);
    }

}