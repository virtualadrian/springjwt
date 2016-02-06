package com.github.schlegel.springjwt.security.permissions.impl;

import com.github.schlegel.springjwt.security.AuthoritiesConstants;
import com.github.schlegel.springjwt.security.permissions.DomainPermissionEvaluator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CompanyPermissionEvaluator implements DomainPermissionEvaluator {

    @Override
    public String getDomainId() {
        return "company";
    }

    @Override
    public boolean hasPermission(UUID targetId, String permission, List<String> roles, String user) {
            if(roles.contains(AuthoritiesConstants.SUPER_ADMIN)) {
                return true;
            } else if(roles.contains(AuthoritiesConstants.COMPANY_ADMIN)) {
                // TODO check if own company
                return false;
            }

        return false;
    }
}
