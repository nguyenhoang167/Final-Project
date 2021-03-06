package vn.edu.vnuk.ecommerce.exception.role;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Role is not exist")
public class RoleNotFoundException extends Exception{

    public RoleNotFoundException(long roleId){
        super("RoleNotFoundException with id = " + roleId);
    }

    public RoleNotFoundException(String roleName){
        super("RoleNotFoundException with role name = " + roleName);
    }

}
