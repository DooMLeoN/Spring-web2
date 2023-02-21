package mate.academy.controller;

import mate.academy.model.Role;
import mate.academy.model.User;
import mate.academy.service.RoleService;
import mate.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/inject")
public class InjectController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String injectData() {
        Role role = roleService.crete(new Role(Role.RoleName.ADMIN));
        roleService.crete(new Role(Role.RoleName.USER));
        User user = new User();
        user.setLogin("bob");
        user.setPassword("123");
        user.setRoles(Set.of(role));
        userService.add(user);
        return "Done!";
    }
}
