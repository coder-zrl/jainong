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
 * @date 2022-04-12 23:56:04
 */
@Data
@TableName("document")
public class DocumentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 单据编号
	 */
	@TableId
	private Long id;
	/**
	 * 单据类型：付款单、收款单
	 */
	private String type;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品数量
	 */
	private String productNumber;
	/**
	 * 创建时间
	 */
	private Date creatAt;

}
