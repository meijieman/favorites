package com.favorites.domain.view;

/**
 * @author YY
 * @version 1.0
 * @InterfaceName: CommentView
 * @Description:
 * @date 2016年9月1日  下午4:03:20
 */
public interface CommentView {
    Long getUserId();

    String getUserName();

    String getProfilePicture();

    String getContent();

    Long getCreateTime();

    Long getReplyUserId();
}
