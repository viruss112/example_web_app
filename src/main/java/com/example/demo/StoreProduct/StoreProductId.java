package com.example.demo.StoreProduct;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StoreProductId implements Serializable {

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "store_id")
    private Integer storeId;

    public StoreProductId(Integer productId, Integer storeId) {
        this.productId = productId;
        this.storeId = storeId;
    }

    public StoreProductId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreProductId that = (StoreProductId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(storeId, that.storeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, storeId);
    }
}
