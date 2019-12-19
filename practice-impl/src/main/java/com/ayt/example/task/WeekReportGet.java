package com.ayt.example.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ayt.example.mapper.dao.WeekReportMapper;
import com.ayt.example.mapper.entity.WeekReport;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * Author ayt  on
 */
@Component
public class WeekReportGet {
	private Logger logger = LoggerFactory.getLogger(WeekReportGet.class);


	@Resource
	WeekReportMapper weekReportMapper;
	@Resource
	StaffGet staffGet;

	//通过部门id批量生成周报
	public void getTaskByDepartId(Integer departId) {
		List<Staff> staffList = staffGet.getDepartStaffList(departId);
		logger.info("当前请求的staffList:{}", JSON.toJSONString(staffList));
		staffList.forEach(staff -> {
			logger.info("当前请求的是：{},{},{}",staff.getStaffName(),staff.getStaffCode(),departId);
			getMyTask(staff, departId);
		});
	}
	//单个员工的任务
	public void getMyTask(Staff staff, Integer departId) {
		String url = "http://cola.dianwoda.cn/hermes/task/list/myCalendarTask/" + staff.getStaffCode();
		String result = HttpRequest.post(url).execute().body();
		JSONObject jsStr = JSONObject.parseObject(result);
		List<CalendarTaskEventDTO> taskLists = JSONArray.parseArray(jsStr.getString("data"), CalendarTaskEventDTO.class);
		taskLists.stream().filter(calendarTaskEventDTO ->
				calendarTaskEventDTO.getStart().compareTo(getThisWeek()) >= 0
		).forEach(calendarTaskEventDTO -> {
			WeekReport weekReport = new WeekReport();
			weekReport.setDemandId(calendarTaskEventDTO.getProgramTask().getRequireId());
			weekReport.setDemandName(calendarTaskEventDTO.getProgramTask().getRequireRelate());
			weekReport.setTaskName(calendarTaskEventDTO.getTitle());
			weekReport.setStatus(String.valueOf(calendarTaskEventDTO.getProgramTask().getPercent()));
			weekReport.setProjectId(calendarTaskEventDTO.getProgramTask().getProgramId());
			weekReport.setProjectName(calendarTaskEventDTO.getProgramName());
			weekReport.setTeamCode(departId);
			weekReport.setStartTime(calendarTaskEventDTO.getProgramTask().getStartTm());
			weekReport.setEndTime(calendarTaskEventDTO.getProgramTask().getEndTm());
			weekReport.setTesterCode(staff.getStaffCode());
			weekReport.setTesterName(staff.getStaffName());
			getWeekOfYear(calendarTaskEventDTO.getProgramTask().getStartTm(), calendarTaskEventDTO.getProgramTask().getPercent(), weekReport);
		});
	}
	//set第几周，并入库
	public void getWeekOfYear(Date startTime, Integer getPercent, WeekReport weekReport) {
		Integer weekYear = 0;
		//创建一个日期实例
		Calendar ca = Calendar.getInstance();
		//实例化一个日期
		ca.setTime(startTime);
		weekYear = ca.get(Calendar.WEEK_OF_YEAR);
		if (getPercent != null & getPercent > 0 & getPercent <= 100) {
			weekReport.setWeekYear(weekYear);
			weekReportMapper.insert(weekReport);
		}
		if (getPercent != null & getPercent >= 0 & getPercent < 100) {
			weekReport.setWeekYear(weekYear + 1);
			weekReportMapper.insert(weekReport);
		}
	}


	public String getThisWeek() {
		Date date = add(new Date(), Calendar.DATE, -1);
		//当前时间往前推5天
		String start = toLocaleString(add(new Date(), Calendar.DATE, -5), "yyyy-MM-dd HH:mm:ss");
		return start;

	}

	public static String toLocaleString(Date date, String dateFormat) {
		if (date == null) {
			return "";
		} else {
			return StringUtils.isBlank(dateFormat) ? (new SimpleDateFormat("yyyy-MM-dd")).format(date) : (new SimpleDateFormat(dateFormat)).format(date);
		}
	}

	public static Date add(Date date, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}
}
