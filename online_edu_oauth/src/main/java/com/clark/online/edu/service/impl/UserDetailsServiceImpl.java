package com.clark.online.edu.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clark.online.edu.entity.uc.UC_Role;
import com.clark.online.edu.entity.uc.UC_User;
import com.clark.online.edu.enums.ResponeCode;
import com.clark.online.edu.service.RoleService;
import com.clark.online.edu.service.UserService;
import com.clark.online.edu.util.Result;
import com.clark.online_edu.store.BaseUserDetail;
/**
 * 用户详情业务实现
 * @author 大仙
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	/**
	 * 配置日志
	 */
	private final static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	/**
	 * 用户业务接口
	 */
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
//    @Autowired
//    private PermissionService permissionService;


    @Override
    public BaseUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<UC_User> userResult = userService.findByUsername(username);
        //判断是否请求成功
        if (userResult.getCode() != ResponeCode.OK.getCode()) {
        	logger.error("用户不存在");
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        //权限集合
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        UC_User user = new UC_User();
        BeanUtils.copyProperties(userResult.getData(),user);
        Result<List<UC_Role>> roleResult = roleService.getRoleByUserId(user.getId());
        if (roleResult.getCode() == ResponeCode.OK.getCode()){
            List<UC_Role> roleVoList = roleResult.getData();
            for (UC_Role role:roleVoList){
                //角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
                grantedAuthorities.add(grantedAuthority);
//                //获取权限
//                Result<List<MenuVo>> perResult  = permissionService.getRolePermission(role.getId());
//                if (perResult.getCode() != StatusCode.SUCCESS_CODE){
//                    List<MenuVo> permissionList = perResult.getData();
//                    for (MenuVo menu:permissionList
//                            ) {
//                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
//                        grantedAuthorities.add(authority);
//                    }
//                }
            }
        }
        User ss_user = new User(user.getUsername(), user.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return new BaseUserDetail(user,ss_user);
    }
}

