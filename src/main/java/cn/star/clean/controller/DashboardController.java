package cn.star.clean.controller;



import cn.star.clean.vo.Stats;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 仪表板页面
 *
 * @param model
 * @return
 */

/**
 */
@Controller
@RequestMapping("/star")
public class DashboardController {


    @GetMapping("/user/dashboard")
    public String dashboard(Model model, Stats stats) {

        Long mIncome, lastIncome;
        Integer curOrderNum, preOrderNum, curRefundOrder, lastRefundOrder, orderNum, orderSum;


        stats.setPv(111);//访问量
        stats.setOrderNumPer("100");//月订单数环比
        stats.setmOrderNum(100);//月订单数
        stats.setmIncome(1);//月收入
        stats.setIncomePer("1");//月收入环比
        stats.setmOrderRefund(2);
        stats.setmOrderRefundPer("1");

        model.addAttribute("dashboard", stats);

        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();

        Date now = new Date();
        //获取三十天前日期
        Calendar theCa = Calendar.getInstance();
        theCa.setTime(now);
        theCa.add(theCa.DATE, -31);//最后一个数字30可改，30天的意思

        Date temp = new Date();


        model.addAttribute("data2", data2);
        model.addAttribute("data3", data3);
        return "dashboard";
    }
}