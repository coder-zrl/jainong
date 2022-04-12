package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.SuppliesStorageDao;
import io.renren.entity.SuppliesStorageEntity;
import io.renren.service.SuppliesStorageService;


@Service("suppliesStorageService")
public class SuppliesStorageServiceImpl extends ServiceImpl<SuppliesStorageDao, SuppliesStorageEntity> implements SuppliesStorageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuppliesStorageEntity> page = this.page(
                new Query<SuppliesStorageEntity>().getPage(params),
                new QueryWrapper<SuppliesStorageEntity>()
        );

        return new PageUtils(page);
    }

}