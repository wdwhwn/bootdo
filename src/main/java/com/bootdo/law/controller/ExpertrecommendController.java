package com.bootdo.law.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.DictService;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.law.domain.ExpertrecommendDO;
import com.bootdo.law.service.ExpertrecommendService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 稳评专家推荐表
 * 
 * @author suhai
 * @email 1992lcg@163.com
 * @date 2019-04-27 16:00:53
 */
 
@Controller
@RequestMapping("/law/expertrecommend")
public class ExpertrecommendController {
	@Autowired
	private ExpertrecommendService expertrecommendService;

	@Autowired
	private BootdoConfig bootdoConfig;

	@Autowired
	private FileService sysFileService;

	@Autowired
	private DictService dictService;

	@GetMapping()
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	String Expertrecommend(Model model){
		List<DictDO> dictDOList=dictService.listByType("expertrecommenddomain");
		model.addAttribute("dictDOList",dictDOList);
		return "law/expertrecommend/expertrecommend";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExpertrecommendDO> expertrecommendList = expertrecommendService.list(query);
		int total = expertrecommendService.count(query);
		PageUtils pageUtils = new PageUtils(expertrecommendList, total);
		return pageUtils;
	}

	@RequestMapping("/download/{id}")
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	public String download(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response){
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			ExpertrecommendDO expertrecommend = expertrecommendService.get(id);
			expertrecommend.setDomain("");
			expertrecommend.setBirthdayStr("");
			expertrecommend.setStartworktimeStr("");
			expertrecommend.setOpiniondateStr("");
			String docFileName ="专家推荐表_"+expertrecommend.getName()+"_"+sdf1.format(new Date()).replaceAll(":","").replaceAll("-","").replaceAll(" ","")+".doc";
			Map<String,Object> rootMap = new HashMap<String,Object>();

			String headpic=expertrecommend.getHeadpic();
			if(headpic != null && headpic.length()>0){
				expertrecommend.setHeadpic(ImageUtils.getImageBase(expertrecommend.getHeadpic(),bootdoConfig.getUploadPath()));
			}else{
				expertrecommend.setHeadpic(ImageUtils.getImageBase("static/expert.png",ResourceUtils.getURL("classpath:").getPath()));
			}
			if(expertrecommend.getBirthday() != null){
				expertrecommend.setBirthdayStr(sdf.format(expertrecommend.getBirthday()));
			}
			if(expertrecommend.getStartworktime() != null){
				expertrecommend.setStartworktimeStr(sdf.format(expertrecommend.getStartworktime()));
			}
			if(expertrecommend.getOpiniondate() != null){
				expertrecommend.setOpiniondateStr(sdf.format(expertrecommend.getOpiniondate()));
			}
			if(expertrecommend.getSex() == 0){
				expertrecommend.setSexStr("男");
			}else if(expertrecommend.getSex() == 1){
				expertrecommend.setSexStr("女");
			}else{
				expertrecommend.setSexStr("");
			}
			if(expertrecommend.getDomain() != null){
				List<DictDO> dictDOList=dictService.listByType("expertrecommenddomain");
				String domainStr="";
				for(DictDO dict:dictDOList){
					for(String domainValue:expertrecommend.getDomain().split(",")){
						if(dict.getValue().equals(domainValue)){
							domainStr=domainStr+dict.getName();
						}
				}
				}
				expertrecommend.setDomain(domainStr);
			}
			rootMap.put("expertrecommend", expertrecommend);
			//rootMap.put("departs", departs);

			FreemarkerUtil.createFile("ExpertrecommendController","expertrecommend.ftl", docFileName, rootMap, request, response, FreemarkerUtil.WORD_FILE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/add")
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	String add(Model model){
		List<DictDO> dictDOList=dictService.listByType("expertrecommenddomain");
		model.addAttribute("dictDOList",dictDOList);
		return "law/expertrecommend/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	String edit(@PathVariable("id") Integer id,Model model){
		ExpertrecommendDO expertrecommend = expertrecommendService.get(id);
		model.addAttribute("expertrecommend", expertrecommend);
		List<DictDO> dictDOList=dictService.listByType("expertrecommenddomain");
		model.addAttribute("dictDOList",dictDOList);
		StringUtils checkContainsMethod = new StringUtils();
		model.addAttribute("checkContainsMethod",checkContainsMethod);
	    return "law/expertrecommend/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	public R save( ExpertrecommendDO expertrecommend){
		if(expertrecommendService.save(expertrecommend)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	public R update( ExpertrecommendDO expertrecommend){
		expertrecommendService.update(expertrecommend);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	public R remove( Integer id){
		if(expertrecommendService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("law:expertrecommend:expertrecommend")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		expertrecommendService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		try {
			FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (sysFileService.save(sysFile) > 0) {
			return R.ok().put("fileName",sysFile.getUrl());
		}
		return R.error();
	}
	
}
