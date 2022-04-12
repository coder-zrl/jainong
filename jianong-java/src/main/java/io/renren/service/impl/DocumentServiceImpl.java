package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.DocumentDao;
import io.renren.entity.DocumentEntity;
import io.renren.service.DocumentService;


@Service("documentService")
public class DocumentServiceImpl extends ServiceImpl<DocumentDao, DocumentEntity> implements DocumentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DocumentEntity> page = this.page(
                new Query<DocumentEntity>().getPage(params),
                new QueryWrapper<DocumentEntity>()
        );

        return new PageUtils(page);
    }

}