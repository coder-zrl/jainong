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
 * @date 2022-04-12 23:56:03
 */
@Data
@TableName("product_inventory")
public class ProductInventoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '产品盘存编号'
	 */
	@TableId
	private Long id;
	/**
	 * 产品编号
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 库存数量
	 */
	private String inventoryNumber;
	/**
	 * 盘点数量
	 */
	private String physicalNumber;
	/**
	 * 产品盘存状态：盘盈、盘亏
	 */
	private String inventoryStatus;

}
