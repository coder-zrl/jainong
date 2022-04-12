package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.InstitutionDao;
import io.renren.entity.InstitutionEntity;
import io.renren.service.InstitutionService;


@Service("institutionService")
public class InstitutionServiceImpl extends ServiceImpl<InstitutionDao, InstitutionEntity> implements InstitutionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InstitutionEntity> page = this.page(
                new Query<InstitutionEntity>().getPage(params),
                new QueryWrapper<InstitutionEntity>()
        );

        return new PageUtils(page);
    }

}