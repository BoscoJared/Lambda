/*
 * This file is generated by jOOQ.
 */
package com.jvmrally.lambda.db;


import com.jvmrally.lambda.db.tables.Audit;
import com.jvmrally.lambda.db.tables.Ban;
import com.jvmrally.lambda.db.tables.DmTimeouts;
import com.jvmrally.lambda.db.tables.Jeps;
import com.jvmrally.lambda.db.tables.Mute;
import com.jvmrally.lambda.db.tables.Tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 2076483972;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>audit</code>.
     */
    public final Audit AUDIT = com.jvmrally.lambda.db.tables.Audit.AUDIT;

    /**
     * The table <code>ban</code>.
     */
    public final Ban BAN = com.jvmrally.lambda.db.tables.Ban.BAN;

    /**
     * The table <code>dm_timeouts</code>.
     */
    public final DmTimeouts DM_TIMEOUTS = com.jvmrally.lambda.db.tables.DmTimeouts.DM_TIMEOUTS;

    /**
     * The table <code>jeps</code>.
     */
    public final Jeps JEPS = com.jvmrally.lambda.db.tables.Jeps.JEPS;

    /**
     * The table <code>mute</code>.
     */
    public final Mute MUTE = com.jvmrally.lambda.db.tables.Mute.MUTE;

    /**
     * The table <code>tags</code>.
     */
    public final Tags TAGS = com.jvmrally.lambda.db.tables.Tags.TAGS;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.AUDIT_SERIAL,
            Sequences.TAGS_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Audit.AUDIT,
            Ban.BAN,
            DmTimeouts.DM_TIMEOUTS,
            Jeps.JEPS,
            Mute.MUTE,
            Tags.TAGS);
    }
}
