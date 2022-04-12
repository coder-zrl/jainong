package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author coder-zrl
 * @email coder-zrl@qq.com
 * @date 2022-04-12 23:56:04
 */
@Data
@TableName("supplies_torage")
public class SuppliesTorageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '物资入库编号'
	 */
	@TableId
	private Long id;
	/**
	 * 物资编号
	 */
	private String suppliesId;
	/**
	 * 物资名称
	 */
	private String suppliesName;
	/**
	 * 物资单价
	 */
	private BigDecimal suppliesSellPrice;
	/**
	 * 物资数量
	 */
	private BigDecimal suppliesNumber;

}
