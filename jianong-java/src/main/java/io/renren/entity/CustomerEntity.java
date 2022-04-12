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
@TableName("customer")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '顾客编号'
	 */
	@TableId
	private Long id;
	/**
	 * 顾客名称
	 */
	private String name;
	/**
	 * 顾客住址
	 */
	private String address;
	/**
	 * 顾客电话
	 */
	private String phoneNumber;

}
