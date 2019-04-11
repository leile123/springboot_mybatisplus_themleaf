package cn.star.clean.controller;


import cn.star.clean.dto.AbcPageDTO;
import cn.star.clean.dto.ResponseMessage;
import cn.star.clean.entity.Abc;
import cn.star.clean.service.IAbcService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Description TODO
 *@Author g2
 *@Date 2019/3/28 上午11:48
 */
@RestController
@RequestMapping("/star/basis/abc")
public class AbcRest {
    @Autowired
    private IAbcService abcService;
    @PostMapping("/insert")
    public ResponseMessage insertAbc(@RequestBody Abc abc){
        abcService.insert(abc);
        return ResponseMessage.ok();
    }
    @GetMapping("/del")
    public ResponseMessage del(@RequestParam long id){
        abcService.deleteById(id);
        return ResponseMessage.ok();
    }


    @GetMapping("/selectOne")
    public ResponseMessage selectOne(@RequestParam long id){
        /**
         * 带条件的EntityWrapper 用法1
         * 用法1 更灵活,支持eq，like，等
         */
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("id", id);
        Abc abc = abcService.selectOne(wrapper);
        return ResponseMessage.ok(abc);
    }

    @GetMapping("/selectOne2")
    public ResponseMessage selectOne2(@RequestParam long id){
        /**
         * 带条件的EntityWrapper 用法2
         * abc对象中的非空值都会作为查询条件，精确查询
         */
        Abc abc = new Abc();
        abc.setId(id);
        Abc dbabc = abcService.selectOne(new EntityWrapper(abc));
        return ResponseMessage.ok(dbabc);
    }

    @PostMapping("/list")
    public ResponseMessage select(@RequestBody AbcPageDTO abcPageDTO){
        Page<Abc> page = new Page<>(abcPageDTO.getCurrent(),abcPageDTO.getPageSize());

        page = abcService.selectPage(page,new EntityWrapper().eq("name",abcPageDTO.getName()));
        return ResponseMessage.ok(page.getRecords()).page(page);
    }

}