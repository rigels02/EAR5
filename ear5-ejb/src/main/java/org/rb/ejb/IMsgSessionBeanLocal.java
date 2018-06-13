package org.rb.ejb;

import javax.ejb.Local;

/**
 *
 * @author raitis
 */
@Local
public interface IMsgSessionBeanLocal {
    
    String getMsg(String info);
}
