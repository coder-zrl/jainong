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

import io.renren.entity.SuppliesStorageEntity;
import io.renren.service.SuppliesStorageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-13 01:23:07
 */
@RestController
@RequestMapping("renren/suppliesstorage")
public class SuppliesStorageController {
    @Autowired
    private SuppliesStorageService suppliesStorageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:suppliesstorage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suppliesStorageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:suppliesstorage:info")
    public R info(@PathVariable("id") Long id){
		SuppliesStorageEntity suppliesStorage = suppliesStorageService.getById(id);

        return R.ok().put("suppliesStorage", suppliesStorage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:suppliesstorage:save")
    public R save(@RequestBody SuppliesStorageEntity suppliesStorage){
		suppliesStorageService.save(suppliesStorage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:suppliesstorage:update")
    public R update(@RequestBody SuppliesStorageEntity suppliesStorage){
		suppliesStorageService.updateById(suppliesStorage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:suppliesstorage:delete")
    public R delete(@RequestBody Long[] ids){
		suppliesStorageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
