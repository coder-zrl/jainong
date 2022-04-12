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
@TableName("product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '产品编号'
	 */
	@TableId
	private Long id;
	/**
	 * 产品名称
	 */
	private String name;
	/**
	 * 产品计数单位
	 */
	private String unit;
	/**
	 * 产品等级
	 */
	private String level;
	/**
	 * 产品产地
	 */
	private String origin;
	/**
	 * 产品运费
	 */
	private BigDecimal freight;
	/**
	 * 产品进价
	 */
	private BigDecimal purchasePrice;
	/**
	 * 产品包装物
	 */
	private String wrapPage;

}
