package com.xulei.observer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/7 22:22
 * @Version 1.0
 */

@Data
public class ContentEvent extends ApplicationEvent {
    private String content;

    /**
     * Create a new ApplicationEvent.
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ContentEvent(Object source) {
        super(source);
    }
    public ContentEvent(Object source, String content){
        super(source);
        this.content = content;
    }
}
