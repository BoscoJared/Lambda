/*
 * This file is generated by jOOQ.
 */
package com.jvmrally.lambda.db.tables.records;


import com.jvmrally.lambda.db.tables.Mute;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MuteRecord extends UpdatableRecordImpl<MuteRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 978488642;

    /**
     * Setter for <code>mute.userid</code>.
     */
    public void setUserid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>mute.userid</code>.
     */
    public Long getUserid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>mute.mute_expiry</code>.
     */
    public void setMuteExpiry(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>mute.mute_expiry</code>.
     */
    public Long getMuteExpiry() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>mute.guild_id</code>.
     */
    public void setGuildId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>mute.guild_id</code>.
     */
    public Long getGuildId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Mute.MUTE.USERID;
    }

    @Override
    public Field<Long> field2() {
        return Mute.MUTE.MUTE_EXPIRY;
    }

    @Override
    public Field<Long> field3() {
        return Mute.MUTE.GUILD_ID;
    }

    @Override
    public Long component1() {
        return getUserid();
    }

    @Override
    public Long component2() {
        return getMuteExpiry();
    }

    @Override
    public Long component3() {
        return getGuildId();
    }

    @Override
    public Long value1() {
        return getUserid();
    }

    @Override
    public Long value2() {
        return getMuteExpiry();
    }

    @Override
    public Long value3() {
        return getGuildId();
    }

    @Override
    public MuteRecord value1(Long value) {
        setUserid(value);
        return this;
    }

    @Override
    public MuteRecord value2(Long value) {
        setMuteExpiry(value);
        return this;
    }

    @Override
    public MuteRecord value3(Long value) {
        setGuildId(value);
        return this;
    }

    @Override
    public MuteRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MuteRecord
     */
    public MuteRecord() {
        super(Mute.MUTE);
    }

    /**
     * Create a detached, initialised MuteRecord
     */
    public MuteRecord(Long userid, Long muteExpiry, Long guildId) {
        super(Mute.MUTE);

        set(0, userid);
        set(1, muteExpiry);
        set(2, guildId);
    }
}
