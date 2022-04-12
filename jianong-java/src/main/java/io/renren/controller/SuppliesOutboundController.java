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

import io.renren.entity.SuppliesOutboundEntity;
import io.renren.service.SuppliesOutboundService;
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
@RequestMapping("renren/suppliesoutbound")
public class SuppliesOutboundController {
    @Autowired
    private SuppliesOutboundService suppliesOutboundService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:suppliesoutbound:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suppliesOutboundService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:suppliesoutbound:info")
    public R info(@PathVariable("id") Long id){
		SuppliesOutboundEntity suppliesOutbound = suppliesOutboundService.getById(id);

        return R.ok().put("suppliesOutbound", suppliesOutbound);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:suppliesoutbound:save")
    public R save(@RequestBody SuppliesOutboundEntity suppliesOutbound){
		suppliesOutboundService.save(suppliesOutbound);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:suppliesoutbound:update")
    public R update(@RequestBody SuppliesOutboundEntity suppliesOutbound){
		suppliesOutboundService.updateById(suppliesOutbound);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:suppliesoutbound:delete")
    public R delete(@RequestBody Long[] ids){
		suppliesOutboundService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
