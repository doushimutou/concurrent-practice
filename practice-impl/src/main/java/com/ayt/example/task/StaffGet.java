package com.ayt.example.task;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Component
public class StaffGet {
	/**
	 * 通过部门ID获取staff信息
	 * @param departId
	 * @return
	 */
	public List<Staff> getDepartStaffList(Integer departId) {
		String url = "http://cola.dianwoda.cn/hermes/staff/departStaff/" + departId;
		String staffs = HttpUtil.get(url);
		JSONObject jsStr = JSONObject.parseObject(staffs);
		List<Staff> staffList = JSONArray.parseArray(jsStr.getString("data"), Staff.class);
		return staffList;
	}
}
