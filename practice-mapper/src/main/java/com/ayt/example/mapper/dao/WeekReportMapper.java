package com.ayt.example.mapper.dao;

import com.ayt.example.mapper.entity.WeekReport;
import com.ayt.example.mapper.entity.WeekReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeekReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int deleteByExample(WeekReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int insert(WeekReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int insertSelective(WeekReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    List<WeekReport> selectByExample(WeekReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    WeekReport selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") WeekReport record, @Param("example") WeekReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") WeekReport record, @Param("example") WeekReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(WeekReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table week_report
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(WeekReport record);
}