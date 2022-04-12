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

import io.renren.entity.ProductionPlanEntity;
import io.renren.service.ProductionPlanService;
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
@RequestMapping("renren/productionplan")
public class ProductionPlanController {
    @Autowired
    private ProductionPlanService productionPlanService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:productionplan:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productionPlanService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:productionplan:info")
    public R info(@PathVariable("id") Long id){
		ProductionPlanEntity productionPlan = productionPlanService.getById(id);

        return R.ok().put("productionPlan", productionPlan);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:productionplan:save")
    public R save(@RequestBody ProductionPlanEntity productionPlan){
		productionPlanService.save(productionPlan);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:productionplan:update")
    public R update(@RequestBody ProductionPlanEntity productionPlan){
		productionPlanService.updateById(productionPlan);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:productionplan:delete")
    public R delete(@RequestBody Long[] ids){
		productionPlanService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
