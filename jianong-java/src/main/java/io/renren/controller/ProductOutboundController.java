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

import io.renren.entity.ProductOutboundEntity;
import io.renren.service.ProductOutboundService;
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
@RequestMapping("renren/productoutbound")
public class ProductOutboundController {
    @Autowired
    private ProductOutboundService productOutboundService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:productoutbound:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productOutboundService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:productoutbound:info")
    public R info(@PathVariable("id") Long id){
		ProductOutboundEntity productOutbound = productOutboundService.getById(id);

        return R.ok().put("productOutbound", productOutbound);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:productoutbound:save")
    public R save(@RequestBody ProductOutboundEntity productOutbound){
		productOutboundService.save(productOutbound);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:productoutbound:update")
    public R update(@RequestBody ProductOutboundEntity productOutbound){
		productOutboundService.updateById(productOutbound);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:productoutbound:delete")
    public R delete(@RequestBody Long[] ids){
		productOutboundService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
