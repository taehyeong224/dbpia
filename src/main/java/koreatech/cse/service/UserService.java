package koreatech.cse.service;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import koreatech.cse.domain.Authority;
import koreatech.cse.domain.User;
import koreatech.cse.domain.oauth2.daum.DaumProfileDetail;
import koreatech.cse.domain.oauth2.facebook.FacebookProfile;
import koreatech.cse.repository.AuthorityMapper;
import koreatech.cse.repository.UserMapper;
import koreatech.cse.service.RandomString;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService
        implements UserDetailsService {
    RandomString randomString = new RandomString();
    @Inject
    private UserMapper userMapper;
    @Inject
    private AuthorityMapper authorityMapper;
    @Inject
    private PasswordEncoder passwordEncoder;

    public int countUsers() {
        return this.userMapper.count();
    }

    public int countAuthorities() {
        return this.authorityMapper.count();
    }

    public void updateKey(String key, int id) {
        this.userMapper.updateKey(key, id);
    }

    public User getKey(String key) {
        return this.userMapper.getKey(key);
    }

    public Boolean signup(User user) {
        if (user.getEmail() == null || user.getPassword() == null) {
            return false;
        }
        user.setPassword(this.passwordEncoder.encode((CharSequence)user.getPassword()));
        this.userMapper.insert(user);
        Authority authority = new Authority();
        authority.setUserId(user.getId());
        authority.setRole("ROLE_USER");
        this.authorityMapper.insert(authority);
        if (user.getEmail().contains("admin")) {
            Authority adminAuthority = new Authority();
            adminAuthority.setUserId(user.getId());
            adminAuthority.setRole("ROLE_ADMIN");
            this.authorityMapper.insert(adminAuthority);
        }
        System.out.println("user created :" + new Date());
        return true;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userMapper.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username/password.");
        }
        List authorities = this.authorityMapper.findByUserId(user.getId());
        user.setAuthorities(authorities);
        System.out.println("user = " + (Object)user);
        return user;
    }

    public String daumLogin(HttpServletRequest request, DaumProfileDetail daumProfileDetail) throws Exception {
        User user = this.userMapper.findByEmail(daumProfileDetail.getUserid());
        if (user == null) {
            user = new User();
            user.setEmail(daumProfileDetail.getUserid());
            user.setName(daumProfileDetail.getNickname());
            user.setAge(-1);
            user.setPassword("0000");
            this.signup(user);
            this.updateKey(this.randomString.getRandom(), user.getId());
        }
        if (user.getKey().equals("test")) {
            this.updateKey(this.randomString.getRandom(), user.getId());
        }
        List authorities = this.authorityMapper.findByUserId(user.getId());
        user.setAuthorities(authorities);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken((Object)user, (Object)"0000", user.getAuthorities());
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication((Authentication)authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", (Object)securityContext);
        return "redirect:/";
    }

    public String facebookLogin(HttpServletRequest request, FacebookProfile facebookProfile) throws Exception {
        User user = this.userMapper.findByEmail(facebookProfile.getId());
        if (user == null) {
            user = new User();
            user.setEmail(facebookProfile.getId());
            user.setName(facebookProfile.getName());
            user.setAge(-2);
            user.setPassword("0000");
            this.signup(user);
            this.updateKey(this.randomString.getRandom(), user.getId());
        }
        if (user.getKey().equals("test")) {
            this.updateKey(this.randomString.getRandom(), user.getId());
        }
        List authorities = this.authorityMapper.findByUserId(user.getId());
        user.setAuthorities(authorities);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken((Object)user, (Object)"0000", user.getAuthorities());
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication((Authentication)authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", (Object)securityContext);
        return "redirect:/";
    }
}