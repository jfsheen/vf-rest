package cc.aisc.config.auth;

import cc.aisc.business.model.auth.User;
import cc.aisc.business.model.auth.dto.Authority;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sjf on 16-7-4.
 */
public class CurrentUserFactory {

    private CurrentUserFactory() {
    }

    public static CurrentUser create(User user, Set<Authority> authorities) {
        DateTime dt = new DateTime();
        return new CurrentUser(
                user.getId(),
                user.getUsername(),
                user.getNicename(),
                user.getMobile(),
                user.getPassword(),
                grantedAuthorities(authorities),
                user.getExpiryAt().after(dt.toDate()),
                true,
                user.getLastLogin().before(dt.plusMonths(1).toDate()),
                true,
                user.getRestPswAt()
        );
    }

    private static List<GrantedAuthority> grantedAuthorities(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuth()))
                .collect(Collectors.toList());
    }
}
