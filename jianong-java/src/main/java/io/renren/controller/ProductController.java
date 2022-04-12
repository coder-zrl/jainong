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

import io.renren.entity.ProductEntity;
import io.renren.service.ProductService;
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
@RequestMapping("renren/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:product:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:product:info")
    public R info(@PathVariable("id") Long id){
		ProductEntity product = productService.getById(id);

        return R.ok().put("product", product);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:product:save")
    public R save(@RequestBody ProductEntity product){
		productService.save(product);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:product:update")
    public R update(@RequestBody ProductEntity product){
		productService.updateById(product);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:product:delete")
    public R delete(@RequestBody Long[] ids){
		productService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
