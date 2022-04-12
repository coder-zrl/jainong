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

import io.renren.entity.SuppliesTorageEntity;
import io.renren.service.SuppliesTorageService;
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
@RequestMapping("renren/suppliestorage")
public class SuppliesTorageController {
    @Autowired
    private SuppliesTorageService suppliesTorageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:suppliestorage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suppliesTorageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:suppliestorage:info")
    public R info(@PathVariable("id") Long id){
		SuppliesTorageEntity suppliesTorage = suppliesTorageService.getById(id);

        return R.ok().put("suppliesTorage", suppliesTorage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:suppliestorage:save")
    public R save(@RequestBody SuppliesTorageEntity suppliesTorage){
		suppliesTorageService.save(suppliesTorage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:suppliestorage:update")
    public R update(@RequestBody SuppliesTorageEntity suppliesTorage){
		suppliesTorageService.updateById(suppliesTorage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:suppliestorage:delete")
    public R delete(@RequestBody Long[] ids){
		suppliesTorageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
