package com.crudproject.utils.generator;

import java.util.EnumSet;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

public class SnowflakeGenerator implements BeforeExecutionGenerator {

    private static final SnowflakeWorker worker = new SnowflakeWorker(1, 1);

    @Override
    public Object generate(SharedSessionContractImplementor session, Object entity, Object currentValue, EventType eventType) {
        return worker.nextId();
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(EventType.INSERT); // ID는 INSERT 시점에만 생성됨
    }

}
