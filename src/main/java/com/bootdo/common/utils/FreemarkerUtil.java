package com.bootdo.common.utils;

import com.bootdo.law.controller.ExpertrecommendController;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

public class FreemarkerUtil {
	private static final Object LOCK = new Object();
	 /**
	  * word文件
	  */
	 public static final int WORD_FILE = 1;
	 /**
	  * excel文件
	  */
	 public static final int EXCEL_FILE = 2;
	 
	 private static Configuration cfg;
	 
	 private static FreemarkerUtil ftl ;
	 
	 private FreemarkerUtil(Class className) throws IOException {
		 cfg = new Configuration();
		 //File path = new File(ResourceUtils.getURL("classpath:").getPath());
		 cfg.setClassForTemplateLoading(className.getClass(), "template");
         //cfg.setDirectoryForTemplateLoading(new File(path.getPath()+templateFolder));
         cfg.setObjectWrapper(new DefaultObjectWrapper());
     }

	 private static void check(Class className,HttpServletRequest request) {
	        if (ftl == null) {
	            synchronized (LOCK) {
	            	try {
						ftl = new FreemarkerUtil(className);
					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
	        }
	       
	    }
	 
	 
	    /**
	     * 创建 word 文档
	     * 必须先设置response导出配置，然后解析模版，否则会出问题
	     * @throws IOException 
	     */
	    public static void createFile(String clazz,String templateName, String docFileName, Map<String,Object> rootMap, HttpServletRequest request, HttpServletResponse response, int fileType) throws IOException {
	  //  	response.resetBuffer();

	    	//设置导出
	        response.addHeader("Cache-Control","no-cache");
	        response.setCharacterEncoding("UTF-8");
	        if( WORD_FILE == fileType){
	        	response.setContentType("application/vnd.ms-word;charset=UTF-8");
	        }else if(EXCEL_FILE == fileType){
	        	response.setContentType("application/octet-stream;charset=UTF-8");
	        }else{
	        	response.setContentType("application/octet-stream");
	        }
	        String ua = request.getHeader("user-agent");
	        ua = ua == null ? null : ua.toLowerCase();
	        if(ua != null && (ua.indexOf("firefox") > 0 || ua.indexOf("safari")>0)){
	        	try {
	        		docFileName = new String(docFileName.getBytes(),"ISO8859-1");
	        		 response.addHeader("Content-Disposition","attachment;filename=" + docFileName);
				} catch (Exception e) {
				}
	        }else{
	        	try {
					docFileName = URLEncoder.encode(docFileName, "utf-8");
			        response.addHeader("Content-Disposition","attachment;filename=" + docFileName);
				} catch (Exception e) {
				}
	        }
	        //check(className,request);
	        //解析模版
			Configuration cfg = new Configuration();
	        if(clazz.equals("ExpertrecommendController")){
				cfg.setClassForTemplateLoading(ExpertrecommendController.class, "../template");
			}

			Template temp = cfg.getTemplate(templateName, "UTF-8");
	        PrintWriter write = response.getWriter();
	        try {
				temp.process(rootMap, write);
			} catch (TemplateException e) {
				e.printStackTrace();
			}finally {
				 if(write != null){
		        	write.flush();
		        	write.close();
		        }
			}
	    }
}
