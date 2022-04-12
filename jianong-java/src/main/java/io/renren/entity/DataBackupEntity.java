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
 * @date 2022-04-13 01:23:07
 */
@Data
@TableName("data_backup")
public class DataBackupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 备份编号
	 */
	@TableId
	private Long id;
	/**
	 * 备份标识
	 */
	private String identification;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 备份时间
	 */
	private Date creatAt;

}
