package com.demo.config.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @decriptiion 监听器有很多中类比,这里只是选择一个ServletRequestListener
 */
@WebListener
@Component
@Slf4j
public class ListenerSample implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.error("requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.error("requestInitialized");
    }
}
