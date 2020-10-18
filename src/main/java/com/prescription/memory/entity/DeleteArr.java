package com.prescription.memory.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Yinjie on 2020/6/4
 */
@Data
public class DeleteArr implements Serializable {
    private Integer[] array;
}
