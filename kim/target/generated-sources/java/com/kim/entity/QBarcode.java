package com.kim.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBarcode is a Querydsl query type for Barcode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBarcode extends EntityPathBase<Barcode> {

    private static final long serialVersionUID = 1715697633L;

    public static final QBarcode barcode = new QBarcode("barcode");

    public final StringPath barcodeId = createString("barcodeId");

    public final StringPath ea = createString("ea");

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath matId = createString("matId");

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final StringPath processId = createString("processId");

    public final NumberPath<Integer> result = createNumber("result", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public QBarcode(String variable) {
        super(Barcode.class, forVariable(variable));
    }

    public QBarcode(Path<? extends Barcode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBarcode(PathMetadata metadata) {
        super(Barcode.class, metadata);
    }

}

