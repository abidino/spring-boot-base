package dev.abidino.nami.auth.application.config;

import dev.abidino.nami.auth.domain.Token;
import dev.abidino.nami.exception.ErrorMessageType;
import dev.abidino.nami.exception.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class CookieFilter extends GenericFilterBean {

    private final UserDetailsService userDetailService;

    public CookieFilter(UserDetailsService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String token = getTokenInCookies(req.getCookies());

        if (StringUtils.hasLength(token)) {
            try {
                UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        String[] values = token.split("&");
        if (values.length == 2) {
            String username = values[0];
            String secret = values[1];
            String calculateHmac = Token.calculateHmac(username);
            if (Objects.equals(secret, calculateHmac)) {
                UserDetails userDetails = userDetailService.loadUserByUsername(username);
                return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
            }
        }

        throw new UnauthorizedException(ErrorMessageType.UNAUTHORIZED.getMessage());
    }

    private String getTokenInCookies(Cookie[] cookies) {
        if (Objects.isNull(cookies)) {
            return null;
        }

        Optional<Cookie> optCookie = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(CookieUtil.TOKEN_COOKIE_NAME))
                .findFirst();

        return optCookie.map(Cookie::getValue).orElse(null);
    }
}
