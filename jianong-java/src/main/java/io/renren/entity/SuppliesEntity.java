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
 * @date 2022-04-12 23:56:03
 */
@Data
@TableName("supplies")
public class SuppliesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '物资编号'
	 */
	@TableId
	private Long id;
	/**
	 * 物资名称
	 */
	private String name;
	/**
	 * 物资计数单位
	 */
	private String unit;
	/**
	 * 物资进价
	 */
	private String purchasePrice;
	/**
	 * 物资售价
	 */
	private BigDecimal sellPrice;

}
