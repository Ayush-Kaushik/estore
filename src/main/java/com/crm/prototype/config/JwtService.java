package com.crm.prototype.config;

import org.springframework.stereotype.Service;

/**
 * Notes:
 *
 * JWT - JSON Web Token
 *
 * header, payload, signature
 *
 * header - 1) type of token 2) algorithm being used
 * payload - contains claims - statement about an entity and additional data
 * signature - maintains the integrity of the token
 */

@Service
public class JwtService {

    public String extractUsername(String token) {
        return null;
    }
}
