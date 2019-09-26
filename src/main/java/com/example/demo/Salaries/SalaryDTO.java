package com.example.demo.Salaries;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

@Data
public class SalaryDTO {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryDTO salaryDTO = (SalaryDTO) o;
        return Objects.equals(salaryId, salaryDTO.salaryId) &&
                Objects.equals(employeeId, salaryDTO.employeeId) &&
                Objects.equals(fromDate, salaryDTO.fromDate) &&
                Objects.equals(toDate, salaryDTO.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salaryId, employeeId, fromDate, toDate);
    }

    private Integer salaryId;
    private Integer employeeId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fromDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date toDate;
    private Long salary;
}
