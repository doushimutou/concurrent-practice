package com.ayt.example.task;

import lombok.Data;

/**
 * Description
 * Author ayt  on
*/
@Data
public class CalendarTaskEventDTO {
	private Integer id;
	private String title;
	private String status;
	private String start;
	private String end;
	private String programName;
	private ProgramTask programTask;
}
