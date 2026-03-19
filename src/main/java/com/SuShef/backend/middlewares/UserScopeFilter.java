package com.SuShef.backend.middlewares;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class UserScopeFilter extends OncePerRequestFilter {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 1. Extract userId from SecurityContext (populated by your JWT logic)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.getPrincipal() instanceof UserPrincipal) {
            Long userId = ((UserPrincipal) auth.getPrincipal()).getId();

            // 2. Unwrap the Hibernate Session and enable the filter
            Session session = entityManager.unwrap(Session.class);
            session.enableFilter("tenantFilter").setParameter("userId", userId);
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            // The filter is naturally scoped to the session/request
            // but you can explicitly disable it if using session pooling
        }
    }
}
