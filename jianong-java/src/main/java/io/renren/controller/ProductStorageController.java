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

import io.renren.entity.ProductStorageEntity;
import io.renren.service.ProductStorageService;
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
@RequestMapping("renren/productstorage")
public class ProductStorageController {
    @Autowired
    private ProductStorageService productStorageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:productstorage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productStorageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:productstorage:info")
    public R info(@PathVariable("id") Long id){
		ProductStorageEntity productStorage = productStorageService.getById(id);

        return R.ok().put("productStorage", productStorage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:productstorage:save")
    public R save(@RequestBody ProductStorageEntity productStorage){
		productStorageService.save(productStorage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:productstorage:update")
    public R update(@RequestBody ProductStorageEntity productStorage){
		productStorageService.updateById(productStorage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:productstorage:delete")
    public R delete(@RequestBody Long[] ids){
		productStorageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
