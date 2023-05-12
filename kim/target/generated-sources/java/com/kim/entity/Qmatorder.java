package com.kim.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * Qmatorder is a Querydsl query type for matorder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class Qmatorder extends EntityPathBase<matorder> {

    private static final long serialVersionUID = -653117811L;

    public static final Qmatorder matorder = new Qmatorder("matorder");

    public final StringPath company = createString("company");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> leadDate = createNumber("leadDate", Integer.class);

    public final NumberPath<Integer> leadTime = createNumber("leadTime", Integer.class);

    public final NumberPath<Integer> min = createNumber("min", Integer.class);

    public final StringPath name = createString("name");

    public Qmatorder(String variable) {
        super(matorder.class, forVariable(variable));
    }

    public Qmatorder(Path<? extends matorder> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qmatorder(PathMetadata metadata) {
        super(matorder.class, metadata);
    }

}

