package sf.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sf.person.dao.ISysUserJpa;
import sf.person.vo.SysUser;

import java.util.List;

@Controller
@RequestMapping("/sysUserController")
public class SysUserController {

    @Autowired
    private ISysUserJpa sysUserJpa;

    @RequestMapping("add")
    public String add(){
        SysUser sysUser = new SysUser();
        sysUser.setAge(21);
        sysUser.setName("bbb");
        sysUserJpa.save(sysUser);
        return "list";
    }

    @RequestMapping("toDelete")
    public String toDelete(Long id){
        sysUserJpa.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(Long id){
        SysUser s = sysUserJpa.getOne(id);
        s.setAge(55);
        sysUserJpa.save(s);
        return "redirect:list";
    }

    @RequestMapping("list")
    public String list(Model model){
        List<SysUser> list = sysUserJpa.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

}
