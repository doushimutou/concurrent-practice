package com.ayt.example.impl;

import com.ayt.example.dto.params.WeekReportDTO;
import com.ayt.example.dto.result.WeekReportResult;
import com.ayt.example.mapper.dao.WeekReportMapper;
import com.ayt.example.mapper.entity.WeekReport;
import com.ayt.example.mapper.entity.WeekReportExample;
import com.ayt.example.provider.WeekReportProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * Author ayt  on
 */
@Component
public class WeekReportProviderImpl implements WeekReportProvider {

	@Resource
	WeekReportMapper weekReportMapper;

	@Override
	public Boolean add(WeekReportDTO weekReportDTO) {
		WeekReport weekReport = new WeekReport();
		BeanUtils.copyProperties(weekReportDTO, weekReport);
		return weekReportMapper.insert(weekReport) > 0;
	}

	@Override
	public Boolean edit(WeekReportDTO weekReportDTO) {
		return null;
	}

	@Override
	public Boolean delete(int id) {
		return weekReportMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public Boolean doWeekReport() {
		return null;
	}

	@Override
	public List<WeekReportResult> search(WeekReportDTO weekReportDTO) {
		WeekReportExample weekReportExample = new WeekReportExample();
		WeekReportExample.Criteria criteria = weekReportExample.createCriteria();
		buildCriteria(criteria, weekReportDTO);
		List<WeekReport> list = weekReportMapper.selectByExample(weekReportExample);
		//构建返回值
		return list.stream().map(weekReport -> {
			WeekReportResult weekReportResult = new WeekReportResult();
			BeanUtils.copyProperties(weekReport, weekReportResult);
			return weekReportResult;
		}).collect(Collectors.toList());
	}

	@Override
	public List<String> getAllProjectName(WeekReportDTO weekReportDTO) {
		List<String> names = new ArrayList<>();
		List<WeekReportResult> list = search(weekReportDTO);
		list.forEach(weekReportResult -> {
			if(weekReportResult.getProjectName()!=null){
				names.add(weekReportResult.getProjectName());
			}
		});
		return names.stream().distinct().collect(Collectors.toList());
	}

	private void buildCriteria(WeekReportExample.Criteria criteria, WeekReportDTO weekReportDTO) {
		if (!StringUtils.isBlank(weekReportDTO.getProjectName())) {
			criteria.andProjectNameLike(weekReportDTO.getProjectName());
		}
		if (weekReportDTO.getTeamCode() != null) {
			criteria.andTeamCodeEqualTo(weekReportDTO.getTeamCode());
		}
		if (weekReportDTO.getStartTime() != null) {
			criteria.andStartTimeLessThanOrEqualTo(weekReportDTO.getStartTime());
		}
		if (weekReportDTO.getEndTime() != null) {
			criteria.andEndTimeGreaterThanOrEqualTo(weekReportDTO.getEndTime());
		}
		if (!StringUtils.isBlank(weekReportDTO.getTesterCode())) {
			criteria.andTesterCodeEqualTo(weekReportDTO.getTesterCode());
		}
		if (weekReportDTO.getWeekYear() != null) {
			criteria.andWeekYearEqualTo(weekReportDTO.getWeekYear());
		}
	}
}
