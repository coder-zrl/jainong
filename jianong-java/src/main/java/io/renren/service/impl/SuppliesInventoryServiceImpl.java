package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.SuppliesInventoryDao;
import io.renren.entity.SuppliesInventoryEntity;
import io.renren.service.SuppliesInventoryService;


@Service("suppliesInventoryService")
public class SuppliesInventoryServiceImpl extends ServiceImpl<SuppliesInventoryDao, SuppliesInventoryEntity> implements SuppliesInventoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuppliesInventoryEntity> page = this.page(
                new Query<SuppliesInventoryEntity>().getPage(params),
                new QueryWrapper<SuppliesInventoryEntity>()
        );

        return new PageUtils(page);
    }

}