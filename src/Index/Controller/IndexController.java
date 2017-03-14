package Index.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面跳转控制器
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/{pagename}")
    public ModelAndView page(@PathVariable(value = "pagename")String pagename){
        ModelAndView modelAndView=new ModelAndView();
        switch (pagename){
            case "index":{
                modelAndView.setViewName(pagename);
            }
            case "articleManagement":{
                modelAndView.setViewName(pagename);
            }
            case "teacherManagement":{
                modelAndView.setViewName(pagename);
            }
            case "editTeacher":{
                modelAndView.setViewName(pagename);
            }
            case "addTeacher":{
                modelAndView.setViewName(pagename);
            }
            case "articleEditor":{
                modelAndView.setViewName(pagename);
            }
            case "article_pc":{
                modelAndView.setViewName(pagename);
            }
            case "article_phone":{
                modelAndView.setViewName(pagename);
            }
            case "picture_setting":{
                modelAndView.setViewName(pagename);
            }case "studentsManagement":{
                modelAndView.setViewName(pagename);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = {"","/login"})
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
