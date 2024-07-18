package com.techgatha.gateway.GatewayServcie.filter;

import org.springframework.http.server.ServerHttpRequest;

import java.util.List;
import java.util.function.Predicate;

public class RouteValidator {

    public static final List<String> openAPiEndPoints =
            List.of("/auth/register","/auth/token","/eureka");

    public Predicate<ServerHttpRequest> isSecured =
            serverHttpRequest -> openAPiEndPoints.stream()
                    .noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
}
