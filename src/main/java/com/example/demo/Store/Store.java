package com.example.demo.Store;

import com.example.demo.Product.Product;
import com.example.demo.StoreProduct.StoreProduct;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stores")
@Data
public class Store {
    @Id
    @GeneratedValue
    @NotNull
    private Integer storeId;
    private String name ;
    private String location;

    @OneToMany(mappedBy = "store")
    private Set<StoreProduct> storeProducts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(storeId, store.storeId) &&
                Objects.equals(name, store.name) &&
                Objects.equals(location, store.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, name, location);
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
