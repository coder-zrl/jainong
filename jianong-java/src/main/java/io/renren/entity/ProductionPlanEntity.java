package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-13 01:23:07
 */
@Data
@TableName("production_plan")
public class ProductionPlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 生产计划编号
	 */
	@TableId
	private Long id;
	/**
	 * 产品名
	 */
	private String productName;
	/**
	 * 计划生产数量
	 */
	private String productionNumber;

}
