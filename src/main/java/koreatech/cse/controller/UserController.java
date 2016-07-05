/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.inject.Inject
 *  koreatech.cse.domain.Searchable
 *  koreatech.cse.domain.User
 *  koreatech.cse.repository.AuthorityMapper
 *  koreatech.cse.repository.UserMapper
 *  koreatech.cse.service.RandomString
 *  koreatech.cse.service.UserService
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.Model
 *  org.springframework.web.bind.annotation.ModelAttribute
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package koreatech.cse.controller;

import java.io.PrintStream;
import java.util.List;
import javax.inject.Inject;
import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.repository.AuthorityMapper;
import koreatech.cse.repository.UserMapper;
import koreatech.cse.service.RandomString;
import koreatech.cse.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value={"/user"})
public class UserController {
    @Inject
    private UserMapper userMapper;
    @Inject
    private UserService userService;
    @Inject
    private AuthorityMapper authorityMapper;

    @RequestMapping(value={"/signup"})
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @RequestMapping(value={"/signup"}, method={RequestMethod.POST})
    @ResponseBody
    public String signup(@ModelAttribute User user) {
        RandomString randomString = new RandomString();
        this.userService.signup(user);
        this.userService.updateKey(randomString.getRandom(), user.getId());
        return "success";
    }

    @RequestMapping(value={"/list"}, method={RequestMethod.GET})
    public String list(Model model, @RequestParam(required=false) String name, @RequestParam(required=false) String email, @RequestParam(required=false) String order) {
        Searchable searchable = new Searchable();
        searchable.setName(name);
        searchable.setEmail(email);
        searchable.setOrderParam(order);
        model.addAttribute("users", this.userMapper.findByProvider(searchable));
        return "list";
    }

    @RequestMapping(value={"/edit"}, method={RequestMethod.GET})
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("user", this.userMapper.findOne(id));
        return "edit";
    }

    @RequestMapping(value={"/edit"}, method={RequestMethod.POST})
    public String edit(@ModelAttribute User user) {
        System.out.println("user = " + user);
        this.userMapper.update(user);
        return "redirect:/";
    }

    @RequestMapping(value={"/signin"})
    public String signin() {
        return "signin";
    }

    @RequestMapping(value={"/signinSuccess"})
    public String signinSuccess() {
        System.out.println("signin Success");
        return "redirect:/";
    }

    @RequestMapping(value={"/signinFailed"})
    @ResponseBody
    public String signinFailed() {
        System.out.println("signin Failed");
        return "signinFailed";
    }

    @PreAuthorize(value="hasRole('ROLE_USER')")
    @RequestMapping(value={"/onlyUserByJava"})
    @ResponseBody
    public String onlyUserByJava() {
        System.out.println("User.current() = " + User.current());
        return "user";
    }

    @PreAuthorize(value="hasRole('ROLE_ADMIN')")
    @RequestMapping(value={"/onlyAdminByJava"})
    @ResponseBody
    public String onlyAdminByJava() {
        System.out.println("User.current() = " + User.current());
        return "admin";
    }

    @RequestMapping(value={"/onlyUserByXml"})
    @ResponseBody
    public String onlyUserByXml() {
        System.out.println("User.current() = " + User.current());
        return "user";
    }

    @RequestMapping(value={"/onlyAdminByXml"})
    @ResponseBody
    public String onlyAdminByXml() {
        System.out.println("User.current() = " + User.current());
        return "admin";
    }

    @RequestMapping(value={"/other"})
    @ResponseBody
    public String other() {
        System.out.println("User.current() = " + User.current());
        return "other";
    }
}