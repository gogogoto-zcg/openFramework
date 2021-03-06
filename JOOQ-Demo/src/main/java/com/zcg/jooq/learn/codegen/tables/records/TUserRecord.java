/*
 * This file is generated by jOOQ.
 */
package com.zcg.jooq.learn.codegen.tables.records;


import com.zcg.jooq.learn.codegen.tables.TUser;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TUserRecord extends UpdatableRecordImpl<TUserRecord> implements Record5<Integer, String, String, String, String> {

    private static final long serialVersionUID = 1098524872;

    /**
     * Setter for <code>learn-jooq.t_user.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>learn-jooq.t_user.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>learn-jooq.t_user.user_name</code>.
     */
    public void setUserName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>learn-jooq.t_user.user_name</code>.
     */
    public String getUserName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>learn-jooq.t_user.user_sex</code>.
     */
    public void setUserSex(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>learn-jooq.t_user.user_sex</code>.
     */
    public String getUserSex() {
        return (String) get(2);
    }

    /**
     * Setter for <code>learn-jooq.t_user.user_address</code>.
     */
    public void setUserAddress(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>learn-jooq.t_user.user_address</code>.
     */
    public String getUserAddress() {
        return (String) get(3);
    }

    /**
     * Setter for <code>learn-jooq.t_user.user_phone</code>.
     */
    public void setUserPhone(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>learn-jooq.t_user.user_phone</code>.
     */
    public String getUserPhone() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TUser.T_USER.USER_ID;
    }

    @Override
    public Field<String> field2() {
        return TUser.T_USER.USER_NAME;
    }

    @Override
    public Field<String> field3() {
        return TUser.T_USER.USER_SEX;
    }

    @Override
    public Field<String> field4() {
        return TUser.T_USER.USER_ADDRESS;
    }

    @Override
    public Field<String> field5() {
        return TUser.T_USER.USER_PHONE;
    }

    @Override
    public Integer component1() {
        return getUserId();
    }

    @Override
    public String component2() {
        return getUserName();
    }

    @Override
    public String component3() {
        return getUserSex();
    }

    @Override
    public String component4() {
        return getUserAddress();
    }

    @Override
    public String component5() {
        return getUserPhone();
    }

    @Override
    public Integer value1() {
        return getUserId();
    }

    @Override
    public String value2() {
        return getUserName();
    }

    @Override
    public String value3() {
        return getUserSex();
    }

    @Override
    public String value4() {
        return getUserAddress();
    }

    @Override
    public String value5() {
        return getUserPhone();
    }

    @Override
    public TUserRecord value1(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public TUserRecord value2(String value) {
        setUserName(value);
        return this;
    }

    @Override
    public TUserRecord value3(String value) {
        setUserSex(value);
        return this;
    }

    @Override
    public TUserRecord value4(String value) {
        setUserAddress(value);
        return this;
    }

    @Override
    public TUserRecord value5(String value) {
        setUserPhone(value);
        return this;
    }

    @Override
    public TUserRecord values(Integer value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TUserRecord
     */
    public TUserRecord() {
        super(TUser.T_USER);
    }

    /**
     * Create a detached, initialised TUserRecord
     */
    public TUserRecord(Integer userId, String userName, String userSex, String userAddress, String userPhone) {
        super(TUser.T_USER);

        set(0, userId);
        set(1, userName);
        set(2, userSex);
        set(3, userAddress);
        set(4, userPhone);
    }
}
