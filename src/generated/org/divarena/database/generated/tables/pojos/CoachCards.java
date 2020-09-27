/*
 * This file is generated by jOOQ.
 */
package org.divarena.database.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CoachCards implements Serializable {

    private static final long serialVersionUID = -438437201;

    private Integer id;
    private String  name;
    private Integer type;
    private Integer value;
    private Integer set;

    public CoachCards() {}

    public CoachCards(CoachCards value) {
        this.id = value.id;
        this.name = value.name;
        this.type = value.type;
        this.value = value.value;
        this.set = value.set;
    }

    public CoachCards(
        Integer id,
        String  name,
        Integer type,
        Integer value,
        Integer set
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.set = set;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getSet() {
        return this.set;
    }

    public void setSet(Integer set) {
        this.set = set;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CoachCards (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(type);
        sb.append(", ").append(value);
        sb.append(", ").append(set);

        sb.append(")");
        return sb.toString();
    }
}