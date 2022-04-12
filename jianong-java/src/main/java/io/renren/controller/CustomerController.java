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

import io.renren.entity.CustomerEntity;
import io.renren.service.CustomerService;
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
@RequestMapping("renren/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:customer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:customer:info")
    public R info(@PathVariable("id") Long id){
		CustomerEntity customer = customerService.getById(id);

        return R.ok().put("customer", customer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:customer:save")
    public R save(@RequestBody CustomerEntity customer){
		customerService.save(customer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:customer:update")
    public R update(@RequestBody CustomerEntity customer){
		customerService.updateById(customer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:customer:delete")
    public R delete(@RequestBody Long[] ids){
		customerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
