package com.bootdo.common.utils;

/**
 * @author bootdo
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
    public boolean thymleafContains(String id,String checkStrs){
        String checkArray[]=checkStrs.split(",");
        boolean returnValue=false;
        for(String check: checkArray){
            if(id !=null && id.equals(check)){
                returnValue=true;
                break;
            }
        }
        return returnValue;
    }
}
