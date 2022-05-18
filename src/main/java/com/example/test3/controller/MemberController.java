package com.example.test3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller // 컨트롤러 빈으로 등록
@RequestMapping("/user")
public class MemberController {
    public static final  String ADMIN_ID = "admin";
    public static final  String ADMIN_PW ="1234";

    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }
    @RequestMapping(value="/loginOK", method= RequestMethod.POST)
    public String loginCheck(String id, String pw,HttpSession session){
        String returnURL ="";
        if(session.getAttribute("login")!=null){
            session.removeAttribute("login");
        }
        if(ADMIN_ID.equals(id) && ADMIN_PW.equals(pw)){
            session.setAttribute("id",id);
            String prirorUrl =(String) session.getAttribute("url_prior_login");
            if(prirorUrl!=null){
                returnURL = "redirect:" + prirorUrl;
                session.removeAttribute("url_prior_login");
            }else{
                returnURL="redirect:/board/list";
            }
        }else{
            returnURL="user/logfail";
        }
        return returnURL;
        }
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("id");
        return "redirect:user/logout";
    }


}