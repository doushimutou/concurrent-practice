package com.ayt.example;

import com.ayt.example.dto.params.WeekReportDTO;
import com.ayt.example.dto.result.WeekReportResult;
import com.ayt.example.impl.WeekReportProviderImpl;
import com.ayt.example.mapper.dao.WeekReportMapper;
import com.ayt.example.provider.WeekReportProvider;
import com.ayt.example.task.WeekReportGet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Controller
@RequestMapping("/")
@CrossOrigin
public class WeekController {

	@Resource
	WeekReportProviderImpl weekReportProvider;
	@Resource
	WeekReportGet weekReportGet;

	@RequestMapping(value = "table/add", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public Boolean add(@RequestBody(required = false) WeekReportDTO weekReportDTO) {
		return weekReportProvider.add(weekReportDTO);
	}

	@RequestMapping(value = "table/list", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public List<WeekReportResult> search(WeekReportDTO weekReportDTO) {
		return weekReportProvider.search(weekReportDTO);
	}

	@RequestMapping(value = "table/delete", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public Boolean delete(@RequestBody int id) {
		return weekReportProvider.delete(id);
	}


	@RequestMapping(value = "table/getData", method = RequestMethod.GET)
	public void getData() {

		weekReportGet.getTaskByDepartId(3);
	}


	@RequestMapping(value = "table/getAllProjectName", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getAllProjectName(WeekReportDTO weekReportDTO) {
		return weekReportProvider.getAllProjectName(weekReportDTO);
	}
}
