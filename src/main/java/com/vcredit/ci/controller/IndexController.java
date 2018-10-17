package com.vcredit.ci.controller;


import com.vcredit.ci.mapper.MemberMapper;
import com.vcredit.ci.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    private MemberMapper memberMapper;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/xss")
    public String xss() {
        return "xss";
    }

    @RequestMapping(value = "/err")
    public String errorPage() {
        return "err";
    }

    @RequestMapping(value = "/suc")
    public String successPage() {
        return "suc";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(HttpServletRequest request, HttpServletResponse response) {
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        List<Member> login = memberMapper.login(loginName, loginPwd);
        Map<String, String> result = new HashMap<>();
        if (CollectionUtils.isEmpty(login)) {
            result.put("status", "404");
            result.put("message", "err");
        } else {
            result.put("status", "200");
            result.put("message", "suc");
        }
        return result;
//        if (CollectionUtils.isEmpty(login)) {
//            try {
//                response.sendRedirect("http://localhost:11140/err");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else {
//            try {
//                response.sendRedirect("http://localhost:11140/suc");
////                request.getRequestDispatcher("/suc").forward(request, response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }
}
