package org.example.interceptor;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TraceIdInterceptor implements HandlerInterceptor {

    private static final String MDC_TRACE_ID_KEY = "traceId";
    private static final String MDC_SPAN_ID_KEY = "spanId";

    @Autowired
    private Tracer tracer;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Span currentSpan = tracer.activeSpan();
        MDC.put(MDC_TRACE_ID_KEY, currentSpan.context().toTraceId());
        MDC.put(MDC_SPAN_ID_KEY, currentSpan.context().toSpanId());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MDC.remove(MDC_TRACE_ID_KEY);
        MDC.remove(MDC_SPAN_ID_KEY);
    }
}
