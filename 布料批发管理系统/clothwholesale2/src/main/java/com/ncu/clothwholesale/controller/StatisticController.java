
package com.ncu.clothwholesale.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ncu.clothwholesale.base.frame.ResultGenerator;
import com.ncu.clothwholesale.service.StatisticsService;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.CommonUtil;

@RestController
@RequestMapping("/statistic")
public class StatisticController {

	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping("/listYear")
	public Object listYearByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(statisticsService.listYearByCondition(args));
	}
	@RequestMapping("/listMonth")
	public Object listMonthByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(statisticsService.listMonthByCondition(args));
	}
	@RequestMapping("/listDay")
	public Object listDayByCondition(HttpServletRequest request){
		Map<String,Object> args = CommonUtil.getMapArguments(request);  
		return ResultGenerator.genSuccessResult(statisticsService.listDayByCondition(args));
	}
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject updateAll(){
		JSONObject json = new JSONObject();
		try {
			statisticsService.updateRecords();
			json.put("success", true);
			
		} catch(BusinessException be){
			be.printStackTrace();
			json.put("success", false);
			json.put("message", be.getMessage());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.put("success", false);
			json.put("message", "失败");
		}
		
		return json;
		
	}
	
}