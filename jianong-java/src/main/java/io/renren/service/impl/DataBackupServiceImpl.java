package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.DataBackupDao;
import io.renren.entity.DataBackupEntity;
import io.renren.service.DataBackupService;


@Service("dataBackupService")
public class DataBackupServiceImpl extends ServiceImpl<DataBackupDao, DataBackupEntity> implements DataBackupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DataBackupEntity> page = this.page(
                new Query<DataBackupEntity>().getPage(params),
                new QueryWrapper<DataBackupEntity>()
        );

        return new PageUtils(page);
    }

}