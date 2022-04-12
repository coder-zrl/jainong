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
@TableName("product_storage")
public class ProductStorageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 产品入库编号
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
	 * 产品进价
	 */
	private BigDecimal purchasePrice;
	/**
	 * 入库总斤数
	 */
	private Double totalJinNumber;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 校验人
	 */
	private String checkOne;
	/**
	 * 经手人
	 */
	private String handler;
	/**
	 * 入库时间
	 */
	private Date storageTime;
	/**
	 * 片名
	 */
	private String geographicalName;
	/**
	 * 农户
	 */
	private String farmerId;

}
