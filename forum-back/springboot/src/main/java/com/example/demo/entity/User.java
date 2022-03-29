package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

/**
 * @author : hongbo
 * @create 2021-11-23-13:03
 **/

@TableName("user")
@Data
public class User implements UserDetails {
    @TableId(value ="id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String introduction;
    private String password;
    private Date createdDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String displayContentOfOptional() {
        if (Optional.ofNullable(introduction).isPresent())
            return Optional.ofNullable(introduction).get();
        else
            return "";
    }

    public String displayParsedDate() {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		return this.createdDate.format(formatter);
        return formatter.format(this.createdDate);
    }
}
