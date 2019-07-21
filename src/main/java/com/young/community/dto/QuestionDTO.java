package com.young.community.dto;

import com.young.community.model.User;
import lombok.Data;

/**
 * 传输层使用的这么一种对象
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
