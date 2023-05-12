package com.kim.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBOM is a Querydsl query type for BOM
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBOM extends EntityPathBase<BOM> {

    private static final long serialVersionUID = 424665505L;

    public static final QBOM bOM = new QBOM("bOM");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> jelly = createNumber("jelly", Integer.class);

    public final NumberPath<Integer> mat1 = createNumber("mat1", Integer.class);

    public final NumberPath<Integer> mat2 = createNumber("mat2", Integer.class);

    public final NumberPath<Integer> mat3 = createNumber("mat3", Integer.class);

    public final NumberPath<Integer> mat4 = createNumber("mat4", Integer.class);

    public final NumberPath<Integer> mat5 = createNumber("mat5", Integer.class);

    public final NumberPath<Integer> mat6 = createNumber("mat6", Integer.class);

    public final NumberPath<Integer> mat7 = createNumber("mat7", Integer.class);

    public final StringPath product = createString("product");

    public QBOM(String variable) {
        super(BOM.class, forVariable(variable));
    }

    public QBOM(Path<? extends BOM> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBOM(PathMetadata metadata) {
        super(BOM.class, metadata);
    }

}

