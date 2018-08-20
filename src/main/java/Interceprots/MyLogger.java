package Interceprots;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyLogger implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AroundInvoke
    public Object logMethodEntry( InvocationContext invocationContext ) throws Exception {
    	 System.out.println("----------------------INTERCEPTOR------------------");
         System.out.println("Entering methid: " + invocationContext.getMethod().getName() );
         return invocationContext.proceed();
     }
}