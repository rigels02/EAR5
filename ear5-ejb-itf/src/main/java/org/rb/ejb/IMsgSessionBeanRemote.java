package org.rb.ejb;

import javax.ejb.Remote;

/**
 *
 * @author raitis
 */
@Remote
public interface IMsgSessionBeanRemote {
    
     String r_getMsg(String info);
}
