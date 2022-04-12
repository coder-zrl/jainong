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
@TableName("institution")
public class InstitutionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * '机构编号'
	 */
	@TableId
	private Long id;
	/**
	 * 机构名称
	 */
	private String name;
	/**
	 * 机构类型：生产基地、批发中心、收购点
	 */
	private String type;
	/**
	 * 机构地址
	 */
	private String address;
	/**
	 * 联系电话
	 */
	private String phoneNumber;

}
