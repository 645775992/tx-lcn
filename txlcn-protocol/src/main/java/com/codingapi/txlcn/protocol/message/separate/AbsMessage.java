package com.codingapi.txlcn.protocol.message.separate;

import com.codingapi.txlcn.protocol.Protocoler;
import com.codingapi.txlcn.protocol.message.Connection;
import com.codingapi.txlcn.protocol.message.Message;
import lombok.Data;
import org.springframework.context.ApplicationContext;

/**
 * @author lorne
 * @date 2020/3/4
 * @description
 */
@Data
public abstract class AbsMessage implements Message {

    /**
     * 是否第一个 node 节点
     */
    protected Boolean isFirstNode = false;

    /**
     * 是否执行过业务逻辑
     */
    protected Boolean isBusinessExecuted = false;

    /**
     * 是否可以回调 TC
     */
    protected Boolean isReadyCallBack = false;

    protected Connection tcConnection;

    protected String messageId;

    @Override
    public void handle(ApplicationContext springContext,
                       Protocoler protocoler,
                       Connection connection) throws Exception {

    }
}
