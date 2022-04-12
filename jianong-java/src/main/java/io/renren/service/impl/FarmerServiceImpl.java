package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.FarmerDao;
import io.renren.entity.FarmerEntity;
import io.renren.service.FarmerService;


@Service("farmerService")
public class FarmerServiceImpl extends ServiceImpl<FarmerDao, FarmerEntity> implements FarmerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FarmerEntity> page = this.page(
                new Query<FarmerEntity>().getPage(params),
                new QueryWrapper<FarmerEntity>()
        );

        return new PageUtils(page);
    }

}