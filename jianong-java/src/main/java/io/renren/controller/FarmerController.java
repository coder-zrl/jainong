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

import io.renren.entity.FarmerEntity;
import io.renren.service.FarmerService;
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
@RequestMapping("renren/farmer")
public class FarmerController {
    @Autowired
    private FarmerService farmerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:farmer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = farmerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:farmer:info")
    public R info(@PathVariable("id") Long id){
		FarmerEntity farmer = farmerService.getById(id);

        return R.ok().put("farmer", farmer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:farmer:save")
    public R save(@RequestBody FarmerEntity farmer){
		farmerService.save(farmer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:farmer:update")
    public R update(@RequestBody FarmerEntity farmer){
		farmerService.updateById(farmer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:farmer:delete")
    public R delete(@RequestBody Long[] ids){
		farmerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
