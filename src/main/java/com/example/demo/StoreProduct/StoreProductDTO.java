package com.example.demo.StoreProduct;

import lombok.Data;

import java.util.Objects;

@Data
public class StoreProductDTO {

    private Integer storeId;
    private Integer productId;
    private String aditionalDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreProductDTO that = (StoreProductDTO) o;
        return Objects.equals(storeId, that.storeId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(aditionalDescription, that.aditionalDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, productId, aditionalDescription);
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getAditionalDescription() {
        return aditionalDescription;
    }

    public void setAditionalDescription(String aditionalDescription) {
        this.aditionalDescription = aditionalDescription;
    }
}
