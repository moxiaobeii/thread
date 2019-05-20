package com.Keyword.transientt;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class User implements Serializable {

    private String username;
    private transient String password;
}
