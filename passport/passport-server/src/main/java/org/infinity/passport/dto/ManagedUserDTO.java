package org.infinity.passport.dto;

import java.time.Instant;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.infinity.passport.domain.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A DTO extending the UserDTO, which is meant to be used in the user management UI.
 */
@ApiModel("用户扩展DTO")
public class ManagedUserDTO extends UserDTO {

    private static final long serialVersionUID        = -8095593058946091229L;

    public static final int   RAW_PASSWORD_MIN_LENGTH = 5;

    public static final int   RAW_PASSWORD_MAX_LENGTH = 50;

    @ApiModelProperty(value = "密码", required = true)
    @NotNull
    @Size(min = RAW_PASSWORD_MIN_LENGTH, max = RAW_PASSWORD_MAX_LENGTH)
    private String            password;

    @ApiModelProperty(value = "创建时间")
    private Instant           createdTime;

    @ApiModelProperty(value = "创建用户")
    private String            createdBy;

    @ApiModelProperty(value = "修改时间")
    private Instant           modifiedTime;

    @ApiModelProperty(value = "修改用户")
    private String            modifiedBy;

    public ManagedUserDTO() {
    }

    public ManagedUserDTO(User user, Set<String> authorities) {
        super(user, authorities);
        this.password = null;
        this.createdTime = user.getCreatedTime();
        this.createdBy = user.getCreatedBy();
        this.modifiedTime = user.getModifiedTime();
        this.modifiedBy = user.getModifiedBy();
    }

    public String getPassword() {
        return password;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getModifiedTime() {
        return modifiedTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public String toString() {
        return "ManagedUserDTO [password=" + password + ", createdTime=" + createdTime + ", createdBy=" + createdBy
                + ", modifiedTime=" + modifiedTime + ", modifiedBy=" + modifiedBy + ", getUserName()=" + getUserName()
                + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
                + getEmail() + ", getActivated()=" + getActivated() + ", getMobileNo()=" + getMobileNo()
                + ", getEnabled()=" + getEnabled() + ", getAuthorities()=" + getAuthorities() + "]";
    }
}
