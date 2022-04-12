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

import io.renren.entity.SuppliesEntity;
import io.renren.service.SuppliesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-12 23:56:03
 */
@RestController
@RequestMapping("renren/supplies")
public class SuppliesController {
    @Autowired
    private SuppliesService suppliesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:supplies:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suppliesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:supplies:info")
    public R info(@PathVariable("id") Long id){
		SuppliesEntity supplies = suppliesService.getById(id);

        return R.ok().put("supplies", supplies);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:supplies:save")
    public R save(@RequestBody SuppliesEntity supplies){
		suppliesService.save(supplies);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:supplies:update")
    public R update(@RequestBody SuppliesEntity supplies){
		suppliesService.updateById(supplies);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:supplies:delete")
    public R delete(@RequestBody Long[] ids){
		suppliesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
