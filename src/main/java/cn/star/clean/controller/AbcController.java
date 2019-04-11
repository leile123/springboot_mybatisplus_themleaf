package cn.star.clean.controller;

import cn.star.clean.entity.Abc;
import cn.star.clean.service.IAbcService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author leile
 * @Date 2019/4/8 下午6:43
 */
@Controller
@RequestMapping("/star/basis/def")
public class AbcController {
    @Autowired
    private IAbcService abcService;
    @GetMapping("/listAbc")
    public String listUser(Model model){
        List<Abc> list = abcService.selectList(new EntityWrapper(new Abc()));
        model.addAttribute("abcs", list);
        return "/abc/list";
    }

    @GetMapping("/user/login")
    public String loginGet(Model model) {
        return "login";
    }
    @RequestMapping("/")
    public String index() {
        return "redirect:/listAbc"; //重定向到 /list
    }
}