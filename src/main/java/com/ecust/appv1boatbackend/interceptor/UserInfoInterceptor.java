package com.ecust.appv1boatbackend.interceptor;


import com.ecust.appv1boatbackend.Exception.LoginFailedException;
import com.ecust.appv1boatbackend.model.pojo.User;
import com.ecust.appv1boatbackend.service.UserLoginService;
import com.ecust.appv1boatbackend.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserInfoInterceptor implements HandlerInterceptor {

    @Autowired
    private UserLoginService userLoginService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        boolean valid = userLoginService.checkTokenValid(token);
        if(!valid){
            throw new LoginFailedException();
        }
        String id = userLoginService.getIdByToken(token);
        ThreadLocalUtil.addCurrentUser(new User(id));
        return valid;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
