package org.springframework.luozlspringtest.springsource.spring08;

import org.springframework.beans.factory.FactoryBean;

public class FurnitureFactoryBean implements FactoryBean<Furniture> {
    private String furniture;

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    @Override
    public Furniture getObject() throws Exception {
        if (null == furniture) {
            throw new IllegalArgumentException("'furniture' is required");
        }
        if ("chair".equals(furniture)) {
            return new Chair();
        } else if ("desk".equals(furniture)) {
            return new Desk();
        } else {
            throw new IllegalArgumentException("'furniture' type error");
        }
    }

    @Override
    public Class<?> getObjectType() {
        if (null == furniture) {
            throw new IllegalArgumentException("'furniture' is required");
        }
        if ("chair".equals(furniture)) {
            return Chair.class;
        } else if ("desk".equals(furniture)) {
            return Desk.class;
        } else {
            throw new IllegalArgumentException("'furniture' type error");
        }
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
