package ku.kinkao.listener;


import ku.kinkao.service.SignupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


import java.time.Instant;


@Component
public class AuthenticationEventListener {


    Logger logger =
            LoggerFactory.getLogger(AuthenticationEventListener.class);


    @Autowired
    private SignupService signupService;


    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event) {
        User user = (User) event.getAuthentication().getPrincipal();
        logger.info(user.getUsername() + " has successfully logged in at "
                + Instant.now());
    }


    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent event) {


        String username = (String) event.getAuthentication().getPrincipal();


        if (signupService.isUsernameAvailable(username))
            logger.warn("Failed login attempt [incorrect USERNAME]");
        else
            logger.warn("Failed login attempt [incorrect PASSWORD]");
    }
}
