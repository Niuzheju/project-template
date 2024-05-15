package com.example.project.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnableRequest extends BaseUpdateRequest {

    @NotNull(message = "是否启用不能为空")
    private Boolean enable;

}
