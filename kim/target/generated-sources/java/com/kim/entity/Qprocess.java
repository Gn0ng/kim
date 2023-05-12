package com.kim.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qprocess is a Querydsl query type for process
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qprocess extends EntityPathBase<process> {

    private static final long serialVersionUID = 75109872L;

    public static final Qprocess process = new Qprocess("process");

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> leadTime = createNumber("leadTime", Integer.class);

    public final NumberPath<Integer> max = createNumber("max", Integer.class);

    public final NumberPath<Integer> min = createNumber("min", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> produce = createNumber("produce", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public Qprocess(String variable) {
        super(process.class, forVariable(variable));
    }

    public Qprocess(Path<? extends process> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qprocess(PathMetadata metadata) {
        super(process.class, metadata);
    }

}

