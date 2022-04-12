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

import io.renren.entity.ProductInventoryEntity;
import io.renren.service.ProductInventoryService;
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
@RequestMapping("renren/productinventory")
public class ProductInventoryController {
    @Autowired
    private ProductInventoryService productInventoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:productinventory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productInventoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:productinventory:info")
    public R info(@PathVariable("id") Long id){
		ProductInventoryEntity productInventory = productInventoryService.getById(id);

        return R.ok().put("productInventory", productInventory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:productinventory:save")
    public R save(@RequestBody ProductInventoryEntity productInventory){
		productInventoryService.save(productInventory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:productinventory:update")
    public R update(@RequestBody ProductInventoryEntity productInventory){
		productInventoryService.updateById(productInventory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:productinventory:delete")
    public R delete(@RequestBody Long[] ids){
		productInventoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
