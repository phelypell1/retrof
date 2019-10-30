package com.example.retrof.representacao;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder



public class Posts {
    private Integer userid;
    private Integer id;
    private String title;
    private String body;





}
