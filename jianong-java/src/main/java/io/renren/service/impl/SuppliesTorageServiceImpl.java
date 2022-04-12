package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.SuppliesTorageDao;
import io.renren.entity.SuppliesTorageEntity;
import io.renren.service.SuppliesTorageService;


@Service("suppliesTorageService")
public class SuppliesTorageServiceImpl extends ServiceImpl<SuppliesTorageDao, SuppliesTorageEntity> implements SuppliesTorageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuppliesTorageEntity> page = this.page(
                new Query<SuppliesTorageEntity>().getPage(params),
                new QueryWrapper<SuppliesTorageEntity>()
        );

        return new PageUtils(page);
    }

}