package com.vcredit.ci.mapper;

import com.vcredit.ci.vo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
  * @Author: QinHaoHao
  * @Description:
  * @Date: Created in 16:52 2018/10/16 
  * @Modifed By:
  */
public interface MemberMapper{

   List<Member> login(@Param("loginName")String loginName, @Param("loginPwd")String LoginPwd);
}