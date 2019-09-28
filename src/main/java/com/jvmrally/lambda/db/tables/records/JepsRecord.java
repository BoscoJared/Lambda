/*
 * This file is generated by jOOQ.
 */
package com.jvmrally.lambda.db.tables.records;


import com.jvmrally.lambda.db.tables.Jeps;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


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
public class JepsRecord extends UpdatableRecordImpl<JepsRecord> implements Record7<Integer, String, String, String, String, String, String> {

    private static final long serialVersionUID = 2047524934;

    /**
     * Setter for <code>jeps.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>jeps.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>jeps.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>jeps.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>jeps.jep_type</code>.
     */
    public void setJepType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>jeps.jep_type</code>.
     */
    public String getJepType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>jeps.jep_status</code>.
     */
    public void setJepStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>jeps.jep_status</code>.
     */
    public String getJepStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>jeps.release</code>.
     */
    public void setRelease(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>jeps.release</code>.
     */
    public String getRelease() {
        return (String) get(4);
    }

    /**
     * Setter for <code>jeps.component</code>.
     */
    public void setComponent(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>jeps.component</code>.
     */
    public String getComponent() {
        return (String) get(5);
    }

    /**
     * Setter for <code>jeps.jep_url</code>.
     */
    public void setJepUrl(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>jeps.jep_url</code>.
     */
    public String getJepUrl() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Jeps.JEPS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Jeps.JEPS.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Jeps.JEPS.JEP_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Jeps.JEPS.JEP_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Jeps.JEPS.RELEASE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Jeps.JEPS.COMPONENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Jeps.JEPS.JEP_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getJepType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getJepStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getRelease();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getComponent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getJepUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getJepType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getJepStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getRelease();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getComponent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getJepUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord value2(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord value3(String value) {
        setJepType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord value4(String value) {
        setJepStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord value5(String value) {
        setRelease(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord value6(String value) {
        setComponent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord value7(String value) {
        setJepUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JepsRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JepsRecord
     */
    public JepsRecord() {
        super(Jeps.JEPS);
    }

    /**
     * Create a detached, initialised JepsRecord
     */
    public JepsRecord(Integer id, String title, String jepType, String jepStatus, String release, String component, String jepUrl) {
        super(Jeps.JEPS);

        set(0, id);
        set(1, title);
        set(2, jepType);
        set(3, jepStatus);
        set(4, release);
        set(5, component);
        set(6, jepUrl);
    }
}
