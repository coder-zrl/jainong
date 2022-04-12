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

import io.renren.entity.DataBackupEntity;
import io.renren.service.DataBackupService;
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
@RequestMapping("renren/databackup")
public class DataBackupController {
    @Autowired
    private DataBackupService dataBackupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:databackup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dataBackupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:databackup:info")
    public R info(@PathVariable("id") Long id){
		DataBackupEntity dataBackup = dataBackupService.getById(id);

        return R.ok().put("dataBackup", dataBackup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:databackup:save")
    public R save(@RequestBody DataBackupEntity dataBackup){
		dataBackupService.save(dataBackup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:databackup:update")
    public R update(@RequestBody DataBackupEntity dataBackup){
		dataBackupService.updateById(dataBackup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("renren:databackup:delete")
    public R delete(@RequestBody Long[] ids){
		dataBackupService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
