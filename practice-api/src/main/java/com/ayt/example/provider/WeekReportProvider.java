package com.ayt.example.provider;

import com.ayt.example.dto.params.WeekReportDTO;
import com.ayt.example.dto.result.WeekReportResult;

import java.util.List;

/**
 * Description
 * Author ayt  on
 */
public interface WeekReportProvider {
	/**
	 * 新增
	 */
	Boolean add(WeekReportDTO weekReportDTO);
	/**
	 * 编辑
	 */
	Boolean edit(WeekReportDTO weekReportDTO);
	/**
	 * 删除
	 */
	Boolean delete(int id);

	/**
	 * 生成日报
	 */
	Boolean doWeekReport();
	/**
	 * 查询周报
	 */
	List<WeekReportResult> search(WeekReportDTO weekReportDTO);


	/**
	 * 查询所有的项目名称
	 * @param weekReportDTO
	 */
	List<String> getAllProjectName(WeekReportDTO weekReportDTO);
}
