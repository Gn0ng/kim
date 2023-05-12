package com.kim.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMat is a Querydsl query type for Mat
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMat extends EntityPathBase<Mat> {

    private static final long serialVersionUID = 424676673L;

    public static final QMat mat = new QMat("mat");

    public final DateTimePath<java.time.LocalDateTime> arrive = createDateTime("arrive", java.time.LocalDateTime.class);

    public final NumberPath<Integer> ea = createNumber("ea", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath product = createString("product");

    public QMat(String variable) {
        super(Mat.class, forVariable(variable));
    }

    public QMat(Path<? extends Mat> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMat(PathMetadata metadata) {
        super(Mat.class, metadata);
    }

}

