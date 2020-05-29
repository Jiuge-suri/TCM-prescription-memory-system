package com.prescription.memory.entity.stuVo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.io.Serializable;

/**
 * Created by Yinjie on 2020/5/25
 */
@Data
@ApiModel(value = "问题记录")
public class ReqQuestionRecord implements Serializable {
    private Integer recordId;

    private Integer questionId;

    private String question;

    private String answer1;

    private String answer2;

    private String answer3;

    private String answer4;

    private String rightanswer;

    private String stuChose;

    private Integer isRight;
}
