package com.ayt.example.dto.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description
 * Author ayt  on
 */
@Data
public class WeekReportResult  implements Serializable{

	private static final long serialVersionUID = 1923067212268136899L;
	/**
	 * 主键 id
	 */
	private Integer id;

	/**
	 * 组别 team_code
	 */
	private Integer teamCode;

	/**
	 * 项目id project_id
	 */
	private Integer projectId;

	/**
	 * 项目名称 project_name
	 */
	private String projectName;

	/**
	 * 需求名称 demand_name
	 */
	private String demandName;

	/**
	 * 需求编号 demand_id
	 */
	private Integer demandId;

	/**
	 * 任务名称 task_name
	 */
	private String taskName;

	/**
	 * 测试人员姓名 tester_name
	 */
	private String testerName;

	/**
	 * 测试人员工号 tester_code
	 */
	private String testerCode;

	/**
	 * 状态（需求评审、测分编写、分支、主干、上线） status
	 */
	private String status;

	/**
	 * 开始时间 start_time
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
	private Date startTime;

	/**
	 * 结束时间 end_time
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
	private Date endTime;
	/**
	 * 第几周 week_year
	 */
	private Integer weekYear;
}
