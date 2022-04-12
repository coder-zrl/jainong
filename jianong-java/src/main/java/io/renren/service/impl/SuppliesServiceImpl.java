package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.SuppliesDao;
import io.renren.entity.SuppliesEntity;
import io.renren.service.SuppliesService;


@Service("suppliesService")
public class SuppliesServiceImpl extends ServiceImpl<SuppliesDao, SuppliesEntity> implements SuppliesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuppliesEntity> page = this.page(
                new Query<SuppliesEntity>().getPage(params),
                new QueryWrapper<SuppliesEntity>()
        );

        return new PageUtils(page);
    }

}