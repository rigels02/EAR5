package org.rb.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author raitis
 */
@Stateless
public class MsgSessionBean implements IMsgSessionBeanRemote, IMsgSessionBeanLocal {

    @Override
    public String r_getMsg(String info) {
        System.out.println("org.rb.ejb.MsgSessionBean.r_getMsg()...");
        return "IMsgSessionBeanRemote: "+info;
    }

    @Override
    public String getMsg(String info) {
        System.out.println("org.rb.ejb.MsgSessionBean.getMsg()...");
         return "IMsgSessionBeanLocal: "+info;
    }

   
}
