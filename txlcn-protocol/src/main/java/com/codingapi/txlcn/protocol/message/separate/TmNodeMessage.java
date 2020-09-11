package com.codingapi.txlcn.protocol.message.separate;

import com.codingapi.txlcn.protocol.Protocoler;
import com.codingapi.txlcn.protocol.await.Lock;
import com.codingapi.txlcn.protocol.await.LockContext;
import com.codingapi.txlcn.protocol.message.Connection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationContext;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020/9/7 10:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TmNodeMessage extends AbsMessage {

    @Override
    public void handle(ApplicationContext springContext, Protocoler protocoler, Connection connection) throws Exception {
        super.handle(springContext, protocoler, connection);
        //唤醒等待消息
        if (messageId != null) {
            Lock lock = LockContext.getInstance().getKey(messageId);
            if (lock != null) {
                lock.setRes(this);
                lock.signal();
            }
        }
    }
}
