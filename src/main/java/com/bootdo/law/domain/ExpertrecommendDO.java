package com.bootdo.law.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 稳评专家推荐表
 * 
 * @author suhai
 * @email 1992lcg@163.com
 * @date 2019-04-27 16:00:53
 */
public class ExpertrecommendDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//姓名
	private String name;
	//性别
	private Integer sex;
	//出生年月
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date birthday;
	//头像
	private String headpic;
	//民族
	private String nation;
	//籍贯
	private String address;
	//健康状况
	private String health;
	//开始工作时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date startworktime;
	//专业技术职务
	private String title;
	//特长
	private String specialskill;
	//专业领域
	private String domain;
	//学历学位-全日制教育
	private String eduFulltimedate;
	//学历学位-毕业院校系及专业
	private String eduFulltimeschool;
	//学历学位-在职教育
	private String eduOnjobdate;
	//学历学位-毕业院校系及专业
	private String eduOnjobschool;
	//工作职责
	private String workduty;
	//工作经历
	private String workexperience;
	//奖惩情况
	private String rewardsandpunish;
	//单位意见
	private String opinion;
	//意见日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date opiniondate;
	//备注
	private String comment;

	private String birthdayStr;

	private String startworktimeStr;

	private String opiniondateStr;

	private String sexStr;

	public String getSexStr() {
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public String getStartworktimeStr() {
		return startworktimeStr;
	}

	public void setStartworktimeStr(String startworktimeStr) {
		this.startworktimeStr = startworktimeStr;
	}

	public String getOpiniondateStr() {
		return opiniondateStr;
	}

	public void setOpiniondateStr(String opiniondateStr) {
		this.opiniondateStr = opiniondateStr;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：出生年月
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生年月
	 */
	public Date getBirthday() {
		return birthday;
	}

	public String getHeadpic() {
		return headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}
	/**
	 * 设置：民族
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**
	 * 获取：民族
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 设置：籍贯
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：籍贯
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：健康状况
	 */
	public void setHealth(String health) {
		this.health = health;
	}
	/**
	 * 获取：健康状况
	 */
	public String getHealth() {
		return health;
	}
	/**
	 * 设置：开始工作时间
	 */
	public void setStartworktime(Date startworktime) {
		this.startworktime = startworktime;
	}
	/**
	 * 获取：开始工作时间
	 */
	public Date getStartworktime() {
		return startworktime;
	}
	/**
	 * 设置：专业技术职务
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：专业技术职务
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：特长
	 */
	public void setSpecialskill(String specialskill) {
		this.specialskill = specialskill;
	}
	/**
	 * 获取：特长
	 */
	public String getSpecialskill() {
		return specialskill;
	}
	/**
	 * 设置：专业领域
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * 获取：专业领域
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * 设置：学历学位-全日制教育
	 */
	public void setEduFulltimedate(String eduFulltimedate) {
		this.eduFulltimedate = eduFulltimedate;
	}
	/**
	 * 获取：学历学位-全日制教育
	 */
	public String getEduFulltimedate() {
		return eduFulltimedate;
	}
	/**
	 * 设置：学历学位-毕业院校系及专业
	 */
	public void setEduFulltimeschool(String eduFulltimeschool) {
		this.eduFulltimeschool = eduFulltimeschool;
	}
	/**
	 * 获取：学历学位-毕业院校系及专业
	 */
	public String getEduFulltimeschool() {
		return eduFulltimeschool;
	}
	/**
	 * 设置：学历学位-在职教育
	 */
	public void setEduOnjobdate(String eduOnjobdate) {
		this.eduOnjobdate = eduOnjobdate;
	}
	/**
	 * 获取：学历学位-在职教育
	 */
	public String getEduOnjobdate() {
		return eduOnjobdate;
	}
	/**
	 * 设置：学历学位-毕业院校系及专业
	 */
	public void setEduOnjobschool(String eduOnjobschool) {
		this.eduOnjobschool = eduOnjobschool;
	}
	/**
	 * 获取：学历学位-毕业院校系及专业
	 */
	public String getEduOnjobschool() {
		return eduOnjobschool;
	}
	/**
	 * 设置：工作职责
	 */
	public void setWorkduty(String workduty) {
		this.workduty = workduty;
	}
	/**
	 * 获取：工作职责
	 */
	public String getWorkduty() {
		return workduty;
	}
	/**
	 * 设置：工作经历
	 */
	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}
	/**
	 * 获取：工作经历
	 */
	public String getWorkexperience() {
		return workexperience;
	}
	/**
	 * 设置：奖惩情况
	 */
	public void setRewardsandpunish(String rewardsandpunish) {
		this.rewardsandpunish = rewardsandpunish;
	}
	/**
	 * 获取：奖惩情况
	 */
	public String getRewardsandpunish() {
		return rewardsandpunish;
	}
	/**
	 * 设置：单位意见
	 */
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	/**
	 * 获取：单位意见
	 */
	public String getOpinion() {
		return opinion;
	}
	/**
	 * 设置：意见日期
	 */
	public void setOpiniondate(Date opiniondate) {
		this.opiniondate = opiniondate;
	}
	/**
	 * 获取：意见日期
	 */
	public Date getOpiniondate() {
		return opiniondate;
	}
	/**
	 * 设置：备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：备注
	 */
	public String getComment() {
		return comment;
	}
}
