package cn.star.clean.controller;

import cn.star.clean.entity.User;
import cn.star.clean.service.IUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author leile
 * @Date 2019/4/8 下午6:43
 */
@Controller
@RequestMapping("/star")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private HttpSession httpSession;

    /**
     * 跳转到登录页面
     */
    @GetMapping("/user/login")
    public String loginGet(Model model) {
        return "login";
    }

    @PostMapping("/user/login")
    public String loginPost(User user, Model model) {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", user.getPassword());
        User basisUser = userService.selectOne(wrapper);
        if (basisUser != null) {
            httpSession.setAttribute("user", basisUser);
            User name = (User) httpSession.getAttribute("user");
            return "redirect:dashboard";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    /**
     * 注册
     */
    @GetMapping("/user/register")
    public String register(Model model) {
        return "register";
    }

    /**
     * 注册
     */
    @PostMapping("/user/register")
    public String registerPost(User user, Model model) {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("username", user.getUsername());
        User basisUser = userService.selectOne(wrapper);
        if (basisUser != null) {
            model.addAttribute("error", "该账号已存在！");
            return "register";
        }
        userService.insert(user);
        model.addAttribute("error", "恭喜您，注册成功！");
        return "login";
    }

    /**
     * 登出
     */
    @GetMapping("/user/logout")
    public String logout(Model model) {
        httpSession.invalidate();
        return "login";
    }

}
