package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.DocumentEntity;
import io.renren.service.DocumentService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-12 23:56:04
 */
@RestController
@RequestMapping("renren/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:document:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = documentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:document:info")
    public R info(@PathVariable("id") Long id){
		DocumentEntity document = documentService.getById(id);

        return R.ok().put("document", document);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:document:save")
    public R save(@RequestBody DocumentEntity document){
		documentService.save(document);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:document:update")
    public R update(@RequestBody DocumentEntity document){
		documentService.updateById(document);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:document:delete")
    public R delete(@RequestBody Long[] ids){
		documentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
