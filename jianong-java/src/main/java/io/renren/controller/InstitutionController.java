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

import io.renren.entity.InstitutionEntity;
import io.renren.service.InstitutionService;
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
@RequestMapping("renren/institution")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:institution:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = institutionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:institution:info")
    public R info(@PathVariable("id") Long id){
		InstitutionEntity institution = institutionService.getById(id);

        return R.ok().put("institution", institution);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:institution:save")
    public R save(@RequestBody InstitutionEntity institution){
		institutionService.save(institution);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:institution:update")
    public R update(@RequestBody InstitutionEntity institution){
		institutionService.updateById(institution);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:institution:delete")
    public R delete(@RequestBody Long[] ids){
		institutionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
