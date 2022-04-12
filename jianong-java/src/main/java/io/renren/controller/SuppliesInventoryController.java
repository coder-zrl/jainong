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

import io.renren.entity.SuppliesInventoryEntity;
import io.renren.service.SuppliesInventoryService;
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
@RequestMapping("renren/suppliesinventory")
public class SuppliesInventoryController {
    @Autowired
    private SuppliesInventoryService suppliesInventoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:suppliesinventory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suppliesInventoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:suppliesinventory:info")
    public R info(@PathVariable("id") Long id){
		SuppliesInventoryEntity suppliesInventory = suppliesInventoryService.getById(id);

        return R.ok().put("suppliesInventory", suppliesInventory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:suppliesinventory:save")
    public R save(@RequestBody SuppliesInventoryEntity suppliesInventory){
		suppliesInventoryService.save(suppliesInventory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:suppliesinventory:update")
    public R update(@RequestBody SuppliesInventoryEntity suppliesInventory){
		suppliesInventoryService.updateById(suppliesInventory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:suppliesinventory:delete")
    public R delete(@RequestBody Long[] ids){
		suppliesInventoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
