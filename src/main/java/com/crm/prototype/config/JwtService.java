package com.crm.prototype.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

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

    private static final String secretKey = "58703273357638792F423F4528482B4D6250655368566D597133743677397A24";

    public String extractUsername(String token) {
        return null;
    }

    /**
     * understand what this does
     * @param token
     * @return
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().build().parseClaimsJws(token).getBody();
    }

    /**
     * understand what this does
     * @return
     */
    private Key getSignInKey() {
        byte [] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
