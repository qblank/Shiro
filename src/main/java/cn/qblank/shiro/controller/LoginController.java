package cn.qblank.shiro.controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/index")
	public String index(String username,String pwd,Model model) {
		Subject subject = SecurityUtils.getSubject();
		//判断是否已经登录
		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
			try {
				subject.login(token);
			} catch (UnknownAccountException e) {
				model.addAttribute("loginErr","用户名错误");
				e.printStackTrace();
				return "login";
			} catch (IncorrectCredentialsException e) {
				model.addAttribute("loginErr","密码错误");
				e.printStackTrace();
				return "login";
			}
		}
		return "index";
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value = "quit")
	public ModelAndView quit() {
		ModelAndView mv = new ModelAndView();
		Subject subject = SecurityUtils.getSubject();
		//退出登录
		subject.logout();
		mv.setViewName("login");
		return mv;
	}
	
	
	
	
}
