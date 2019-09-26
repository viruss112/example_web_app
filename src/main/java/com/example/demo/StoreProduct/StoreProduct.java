package com.example.demo.StoreProduct;

import com.example.demo.Product.Product;
import com.example.demo.Store.Store;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "store_product")
public class StoreProduct {
    @EmbeddedId
    private StoreProductId storeProductId;

    private String aditionalDescription;

    public StoreProduct(Store store, Product product) {
        this.store = store;
        this.product = product;
        this.storeProductId = new StoreProductId(product.getProductId(),store.getStoreId());
    }

    public StoreProduct() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("storeId")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreProduct that = (StoreProduct) o;
        return Objects.equals(storeProductId, that.storeProductId) &&
                Objects.equals(store, that.store) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeProductId, store, product);
    }

    public StoreProductId getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(StoreProductId storeProductId) {
        this.storeProductId = storeProductId;
    }

    public String getAditionalDescription() {
        return aditionalDescription;
    }

    public void setAditionalDescription(String aditionalDescription) {
        this.aditionalDescription = aditionalDescription;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
