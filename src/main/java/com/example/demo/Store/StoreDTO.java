package com.example.demo.Store;

import lombok.Data;

import java.util.Objects;

@Data
public class StoreDTO {

    private Integer storeId;
    private String name;
    private String location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDTO storeDTO = (StoreDTO) o;
        return Objects.equals(storeId, storeDTO.storeId) &&
                Objects.equals(name, storeDTO.name) &&
                Objects.equals(location, storeDTO.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, name, location);
    }
}
