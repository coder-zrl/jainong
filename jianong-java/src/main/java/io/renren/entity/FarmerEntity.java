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
@TableName("farmer")
public class FarmerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '农户编号'
	 */
	@TableId
	private Long id;
	/**
	 * 农户名称
	 */
	private String name;
	/**
	 * 农户住址
	 */
	private String address;
	/**
	 * 联系电话
	 */
	private String phoneNumber;
	/**
	 * 播种面积
	 */
	private String sownArea;

}
