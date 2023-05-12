package com.kim.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 94730991L;

    public static final QOrder order = new QOrder("order1");

    public final DateTimePath<java.time.LocalDateTime> comDate = createDateTime("comDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> jelly = createNumber("jelly", Integer.class);

    public final StringPath lotNum = createString("lotNum");

    public final StringPath orderBy = createString("orderBy");

    public final DateTimePath<java.time.LocalDateTime> orderDate = createDateTime("orderDate", java.time.LocalDateTime.class);

    public final StringPath product = createString("product");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final StringPath status = createString("status");

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    public QOrder(Path<? extends Order> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata metadata) {
        super(Order.class, metadata);
    }

}

