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
@TableName("supplies_outbound")
public class SuppliesOutboundEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '出库编号'
	 */
	@TableId
	private Long id;
	/**
	 * 农户编号
	 */
	private String farmerId;
	/**
	 * 农户名称
	 */
	private String farmerName;
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
